package com.cs157a1.payMe.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cs157a1.payMe.Entity.Account;
import com.cs157a1.payMe.Services.AccountServices;

@Controller
@SessionAttributes("accounts")
public class DashboardController {
	
	@Autowired
	private AccountServices accountService;
	
	
	@ModelAttribute("accounts")
	public Account getAccount(Principal principal){
		Account account = accountService.returnAccountByUsername(principal.getName());
		return account;
	}
	

	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String helloUser() {
		return "dashboard";
	}
	
	
	@RequestMapping(value ="/friends", method = RequestMethod.GET)
	public String showFriends(@ModelAttribute("accounts")Account account, ModelMap model) {
		accountService.getFriendsByAccount(account.getUsername());
		return "friends";
	}
	
	@RequestMapping(value="/friends/add", method=RequestMethod.GET)
	public String addFriendForm(@RequestParam(value="username", required =false) String username, ModelMap model) {
		Account friend = new Account();
		if(username != null) {
		friend = accountService.returnAccountByUsername(username);
		}
		System.out.println(friend.getUsername());
		model.addAttribute("friendAccount", friend);
		return "add";
	}
	
	@RequestMapping(value = "/friends/add", method = RequestMethod.POST)
	public String addFriend(@ModelAttribute("accounts")Account account, ModelMap model) {
		return "add";
		
	}
	
	@RequestMapping(value="/friends?search", method = RequestMethod.GET)
	public String searchFriend(@ModelAttribute("accounts")Account account) {
		return "friends?search";
	}
	
	
	
	
	
}
