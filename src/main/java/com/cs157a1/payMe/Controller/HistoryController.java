package com.cs157a1.payMe.Controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cs157a1.payMe.Entity.Account;
import com.cs157a1.payMe.Entity.Comment;
import com.cs157a1.payMe.Entity.TransType;
import com.cs157a1.payMe.Entity.Transactions;
import com.cs157a1.payMe.Entity.User;
import com.cs157a1.payMe.Services.CommentsServices;
import com.cs157a1.payMe.Services.TransactionsServices;
import com.cs157a1.payMe.Services.UsersServices;

@Controller
@SessionAttributes("accounts")
public class HistoryController {
	
	@Autowired
	private CommentsServices commentService;
	
	@Autowired
	private TransactionsServices tranService;
	
	@Autowired
	private UsersServices userServices;
	
	@ModelAttribute("accounts")
	public User getAccount(Principal principal){
		User account = userServices.returnUserByUsername(principal.getName());
		return account;
	}
	
	@ModelAttribute("history")
	public List<Transactions> getTransactionsList(){
		List<Transactions> trans = new ArrayList<>();
		return trans;
	}
	
	@ModelAttribute("comments")
	public List<Comment> getCommentsbyTransactions(){
		List<Comment> commentList = new ArrayList<>();
		return commentList;
	}
	
	@ModelAttribute("comment")
	public Comment getComment() {
		Comment comment = new Comment();
		return comment;
	}
	
	@ModelAttribute("transaction")
	public Transactions getTransactions() {
		Transactions trans = new Transactions();
		return trans;
	}
	
	public class AcceptSubmission {
		private String receivedUserName;
		private String sentUserName;
		private double amount;
		private int transId;
		
		public AcceptSubmission() {};
		public AcceptSubmission(String receivedUserName, double amount, String sentUserName, int transId) {
			this.setReceivedUserName(receivedUserName);
			this.setAmount(amount);
			this.setSentUserName(sentUserName);
			this.setTransId(transId);
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public String getReceivedUserName() {
			return receivedUserName;
		}
		public void setReceivedUserName(String receivedUserName) {
			this.receivedUserName = receivedUserName;
		}
		public String getSentUserName() {
			return sentUserName;
		}
		public void setSentUserName(String sentUserName) {
			this.sentUserName = sentUserName;
		}
		public int getTransId() {
			return transId;
		}
		public void setTransId(int transId) {
			this.transId = transId;
		}
		
	}
	
	@ModelAttribute("acceptSubmission")
	public AcceptSubmission getSubmission() {
		return new AcceptSubmission();
	}
	
	@RequestMapping(value = "/history", method = RequestMethod.GET)
	public String getHistory(ModelMap map, @ModelAttribute("accounts") Account account, @ModelAttribute("history") List<Transactions> trans) {
		trans.addAll(tranService.returnUsersRequest("TRANSFER", account.getUsername()));
		trans.addAll(tranService.returnUsersTransfers("TRANSFER", account.getUsername()));
		map.addAttribute("trans",trans);
		return "history";
	}
	
	@RequestMapping(value="/transfer/accept", method=RequestMethod.POST)
	public String sendMoney(@ModelAttribute("acceptSubmission") AcceptSubmission submission) {
		double amount = submission.getAmount();
		User sender  = userServices.returnUserByUsername(submission.getSentUserName());
		User receiver = userServices.returnUserByUsername(submission.getReceivedUserName());
		sender.setBalance(sender.getBalance()+amount);
		receiver.setBalance(receiver.getBalance()-amount);
		tranService.addTransactionsToDB(new Transactions(TransType.TRANSFER, amount), receiver.getUsername(), sender.getUsername());
		tranService.deleteUserHasTransactions(submission.getTransId(), receiver.getUsername());
		userServices.updateUser(sender);
		userServices.updateUser(receiver);
		return "redirect:/transfer?complete";
	}
	

	@RequestMapping(value = "/transactions/{id}", method = RequestMethod.GET)
	public String getTransWithId(ModelMap map, @PathVariable(value ="id", required = true) int id, Transactions trans, @ModelAttribute("comments") List<Comment> comments) {
		trans = tranService.returnTransactionsBytransID(id);
		comments  = commentService.returnAllCommentsFromTransactions(id);
		map.addAttribute("comments",comments);
		map.addAttribute("trans", trans);
		return "transaction";
	}
	
	
	@RequestMapping(value = "/request/view", method = RequestMethod.GET)
	public String getRequests(@ModelAttribute("accounts") Account account, @ModelAttribute("acceptSubmission") AcceptSubmission submission, @ModelAttribute("history") List<Transactions> trans, ModelMap map) {
		trans.addAll(tranService.returnUsersTransfers("REQUEST", account.getUsername()));
		map.addAttribute("acceptSubmission", submission);
		map.addAttribute("trans",trans);
		return "view";
	}
	
	//THIS NEEDS TO BE FIXED.
	@RequestMapping(value = "/transactions/{id}/addComment", method = RequestMethod.GET)
	public String getCommentForm(@PathVariable(value="id", required = true)int id, ModelMap model, @ModelAttribute("transaction")Transactions trans, @ModelAttribute("comment") Comment comment) {
		trans = tranService.returnTransactionsBytransID(id);
		model.addAttribute("trans", trans);
		model.addAttribute("comment", comment);
		return "addComment";
	}
	
	@RequestMapping(value = "/transactions/{id}/addComment", method = RequestMethod.POST)
	public String sendCommentForm(@PathVariable(value="id", required = true)int id, @ModelAttribute("comment") Comment comment, @ModelAttribute("accounts")Account account, BindingResult result) {
		if(result.hasErrors()) {
			return "addComment";
		}
		else {
		Transactions trans = tranService.returnTransactionsBytransID(id);
		System.out.println(comment.getDescription());
		comment.setTransactions(trans);
		System.out.println(comment.getTransactions().getTransID());
		comment.setUser((User)account);
		System.out.println(comment.getUser().getUsername());
		commentService.addCommentToDB(comment);
		return "redirect:/transactions/" + id;
		}
	}
	
}
