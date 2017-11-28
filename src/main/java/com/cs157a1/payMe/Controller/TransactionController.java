package com.cs157a1.payMe.Controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	
	@ModelAttribute("transferList")
	public TransactionList getList() {
		TransactionList list = new TransactionList();
		return list;
	}
	
	public class TransactionList{
		public String transactionList;
		public int amount;
		public TransactionList() {
			
		}
		
		public TransactionList(String transactionList, int amount) {
			this.transactionList = transactionList;
			this.amount = amount;
		}
		
		public String gettransactionList() {
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
	public String getTransferForm(@ModelAttribute("transferList")TransactionList str,ModelMap map) {
		map.addAttribute("transferAccount", str);
		return "transfer";
	}

	@RequestMapping(value="/transfer", method = RequestMethod.POST)
	public String sendTransferForm(@ModelAttribute("transferAccount") Account[] transferAccountList, ModelMap map) {
		return "transfer";
	}
	
	
	
}
