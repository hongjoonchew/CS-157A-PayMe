package com.cs157a1.payMe.Controller;

import java.security.Principal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cs157a1.payMe.Entity.Account;
import com.cs157a1.payMe.Entity.TransType;
import com.cs157a1.payMe.Entity.Transactions;
import com.cs157a1.payMe.Entity.User;
import com.cs157a1.payMe.Services.AccountServices;
import com.cs157a1.payMe.Services.TransactionsServices;
import com.cs157a1.payMe.Services.UsersServices;

@Controller
@SessionAttributes("accounts")
public class TransactionController {

	@Autowired
	public AccountServices accountService;
	
	@Autowired
	public TransactionsServices transactionService;
	
	@Autowired
	private UsersServices userServices;
	
	@ModelAttribute("accounts")
	public User getAccount(Principal principal){
		User account = userServices.returnUserByUsername(principal.getName());
		return account;
	}
	
	
	@ModelAttribute("transferAccount")
	public TransactionList getList() {
		TransactionList list = new TransactionList();
		return list;
	}
	
	
	public class TransactionList{
		@NotNull
		@NotBlank
		public String transactionList;
		
		public int amount;
		public TransactionList() {
			
		}
		
		public TransactionList(String transactionList, int amount) {
			this.transactionList = transactionList;
			this.amount = amount;
		}
		
		public String getTransactionList() {
			return transactionList;
		}
		
		public void setTransactionList(String list) {
			transactionList = list;
		}
		
		public int getAmount() {
			return amount;
		}
		
		public void setAmount(int amount) {
			this.amount = amount;
		}
	}
	
	@RequestMapping(value="/transfer", method = RequestMethod.GET)
	public String getTransferForm(@ModelAttribute("transferAccount")TransactionList str, @RequestParam(value="target", required =false)String target,ModelMap map) {
		if(target != null) {
			Account tar = accountService.returnAccountByUsername(target);
			map.addAttribute("target", tar);
		}
		map.addAttribute("transferAccount", str);
		return "transfer";
	}

	@RequestMapping(value="/transfer", method = RequestMethod.POST)
	public String sendTransferForm(@Valid @ModelAttribute("transferAccount") TransactionList str, @ModelAttribute("accounts") Account acct, BindingResult binding, ModelMap map) {
		String[] usernames = str.getTransactionList().split(",");
		String error = "Account(s) with username ";
		User sendingUser = userServices.returnUserByUsername(acct.getUsername());
		boolean hasErrors = false;
		if(binding.hasErrors()) {
			return "transfer";
		}
		else {
			int amount = str.getAmount();
			if(sendingUser.getBalance() < amount) {
				map.addAttribute("error","Insufficient amount.");
				return "transfer";
			}
			for (String username: usernames) {
				if(accountService.returnAccountByUsername(username) == null) {
					error = error + username + ", ";
					hasErrors = true;
				}
			}
			if (hasErrors) {
				error = "do not exist.";
				map.addAttribute("error", error);
				return "transfer";
			}
			for (String username: usernames) {
				if(accountService.returnAccountByUsername(username) != null) {
				User receivingUser = userServices.returnUserByUsername(username);
				receivingUser.setBalance(receivingUser.getBalance()+amount);
				sendingUser.setBalance(sendingUser.getBalance()-amount);
				Transactions trans = new Transactions(TransType.TRANSFER, amount);
				transactionService.addTransactionsToDB(trans,sendingUser.getUsername(),receivingUser.getUsername());
				userServices.updateUser(receivingUser);
				userServices.updateUser(sendingUser);
				}
			}
		return "redirect:/transfer?complete";
		}
	}
	
	
	
	
	@RequestMapping(value="/request", method = RequestMethod.GET)
	public String getRequestForm(@RequestParam(value="target", required =false) String target,@ModelAttribute("transferAccount")TransactionList request,@ModelAttribute("accounts")Account account, ModelMap model) {
		model.addAttribute("transferAccount",request);
		if(target != null) {
			Account tar = accountService.returnAccountByUsername(target);
			model.addAttribute("target", tar);
		}
		return "requestForm";
	}
	
	@RequestMapping(value="/request", method = RequestMethod.POST)
	public String sendRequestForm(@Valid @ModelAttribute("transferAccount")TransactionList request, @ModelAttribute("accounts") Account account, ModelMap model, BindingResult binding) {
		String[] usernames = request.getTransactionList().split(",");
		String error = "Account(s) with username ";
		boolean hasErrors = false;
		int amount = request.getAmount();
		if(binding.hasErrors()) {
			return "requestForm";
		}
		else {
			for (String username: usernames) {
				if(userServices.returnUserByUsername(username) == null) {
					error = error + username + ", ";
					hasErrors = true;
				}
			}
			if (hasErrors) {
				error = "do not exist.";
				model.addAttribute("error", error);
				return "requestForm";
			}
		}
		Transactions trans = new Transactions(TransType.REQUEST, amount);
		for(String username: usernames) {
		transactionService.addTransactionsToDB(trans, account.getUsername(), username);
		}
		return "redirect:/request?complete";
	}
	
}
