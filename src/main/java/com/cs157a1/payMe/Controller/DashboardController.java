package com.cs157a1.payMe.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		model = accountByUsername(account, model, principal.getName());
		return "dashboard";
	}
	
	
	@RequestMapping(value ="/friends", method = RequestMethod.GET)
	public String showFriends(@RequestParam("accountName") String accountName, @ModelAttribute("accounts")Account account, ModelMap model) {
		model = accountByUsername(account, model, accountName);
		return "friends";
	}
	
	
	@RequestMapping(value = "/friends", method = RequestMethod.POST)
	public String addFriend(@ModelAttribute("accounts")Account account) {
		return "friends?search";
		
	}
	
	@RequestMapping(value="/friends?search", method = RequestMethod.GET)
	public String searchFriend(@ModelAttribute("accounts")Account account) {
		return "friends?search";
	}
	
	
	
	public ModelMap accountByUsername(@ModelAttribute("accounts")Account account, ModelMap model, String accountName) {
		account = accountService.returnAccountByUsername(accountName);
		model.addAttribute("account",account);
		return model;
	}
	
}
