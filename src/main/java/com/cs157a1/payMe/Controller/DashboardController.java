package com.cs157a1.payMe.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cs157a1.payMe.Entity.Account;
import com.cs157a1.payMe.Services.AccountServices;

@Controller
public class DashboardController {
	
	@Autowired
	private AccountServices accountService;
	
	
	@ModelAttribute("accounts")
	public Account getAccount(){
		Account account = new Account();
		return account;
	}
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String helloUser(@ModelAttribute("accounts")Account account, ModelMap model, Principal principal) {
		String name = principal.getName();
		account = accountService.returnAccountByUsername(name);
		model.addAttribute("account",account);
		return "dashboard";
	}
	
}
