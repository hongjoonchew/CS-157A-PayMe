package com.cs157a1.payMe.Controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cs157a1.payMe.Entity.Account;
import com.cs157a1.payMe.Entity.Comment;
import com.cs157a1.payMe.Entity.Transactions;
import com.cs157a1.payMe.Services.AccountServices;
import com.cs157a1.payMe.Services.CommentsServices;
import com.cs157a1.payMe.Services.TransactionsServices;

@Controller
@SessionAttributes("accounts")
public class HistoryController {
	
	@Autowired
	private AccountServices accountService;
	
	@Autowired
	private CommentsServices commentService;
	
	@Autowired
	private TransactionsServices tranService;
	
	@ModelAttribute("accounts")
	public Account getAccount(Principal principal){
		Account account = accountService.returnAccountByUsername(principal.getName());
		return account;
	}
	
	@ModelAttribute("history")
	public List<Transactions> getTransactions(){
		List<Transactions> trans = new ArrayList<>();
		return trans;
	}
	
	@ModelAttribute("comments")
	public List<Comment> getCommentsbyTransactions(){
		List<Comment> commentList = new ArrayList<>();
		return commentList;
	}
	
	@RequestMapping(value = "/history", method = RequestMethod.GET)
	public String getHistory(ModelMap map, @ModelAttribute("accounts") Account account, @ModelAttribute("history") List<Transactions> trans) {
		trans.addAll(tranService.returnUsersRequest("Transfer", account.getUsername()));
		map.addAllAttributes(trans);
		return "history";
	}
	

	@RequestMapping(value = "/transactions/{id}", method = RequestMethod.GET)
	public String getTransWithId(ModelMap map, @PathVariable(value ="id", required = true) int id, Transactions trans, @ModelAttribute("comments") List<Comment> comments) {
		trans = tranService.returnTransactionsBytransID(id);
		comments  = commentService.returnAllCommentsFromTransactions(id);
		map.addAllAttributes(comments);
		map.addAttribute("trans", trans);
		return "{id}";
	}
	
	@RequestMapping(value = "/request/view", method = RequestMethod.GET)
	public String getRequests(ModelMap map, @ModelAttribute("accounts") Account account, @ModelAttribute("history") List<Transactions> trans) {
		trans.addAll(tranService.returnUsersTransfers("Requests", account.getUsername()));
		return "view";
	}
	
	//THIS NEEDS TO BE FIXED.
	@RequestMapping(value = "/transactions/{id}/addComment", method = RequestMethod.GET)
	public String getCommentForm() {
		return null;
	}
	
}
