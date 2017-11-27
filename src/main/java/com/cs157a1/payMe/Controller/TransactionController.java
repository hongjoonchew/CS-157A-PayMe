package com.cs157a1.payMe.Controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;

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

	public AccountServices accountService;
	
	@ModelAttribute("accounts")
	public Account getAccount(Principal principal){
		Account account = accountService.returnAccountByUsername(principal.getName());
		return account;
	}
	
	@ModelAttribute("transferAccount")
	public Collection<Account> getTransferAccountList(){
		Collection<Account> transferAccountList = new ArrayList<>();
		return transferAccountList;
	}
	
	@RequestMapping(value="/transfer", method = RequestMethod.GET)
	public String getTransferForm(@ModelAttribute("transferAccount") Collection<Account> transferAccountList, ModelMap map) {
		map.addAllAttributes(transferAccountList);
		return "/transfer";
	}

	
	
	@RequestMapping(value="/transfer", params = {"addRow"})
	public String addTransferRow() {
		return null;
	}
	
	
}
