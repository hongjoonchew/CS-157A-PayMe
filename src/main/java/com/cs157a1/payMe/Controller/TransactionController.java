package com.cs157a1.payMe.Controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;

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
import com.cs157a1.payMe.Services.AccountServices;

@Controller
@SessionAttributes("accounts")
public class TransactionController {

	@Autowired
	public AccountServices accountService;
	
	@ModelAttribute("accounts")
	public Account getAccount(Principal principal){
		Account account = accountService.returnAccountByUsername(principal.getName());
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
	public String sendTransferForm(@Valid @ModelAttribute("transferAccount") TransactionList str, BindingResult binding) {
		String[] usernames = str.getTransactionList().split(",");
		if(binding.hasErrors()) {
			return "transfer";
		}
		else {
		return "transfer";
		}
	}
	
	
	
}
