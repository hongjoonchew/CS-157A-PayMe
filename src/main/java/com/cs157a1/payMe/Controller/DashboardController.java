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
import com.cs157a1.payMe.Entity.User;
import com.cs157a1.payMe.Services.AccountServices;
import com.cs157a1.payMe.Services.UsersServices;

@Controller
@SessionAttributes("accounts")
public class DashboardController {
	
	@Autowired
	private AccountServices accountService;
	
	@Autowired
	private UsersServices userServices;
	
	
	@ModelAttribute("accounts")
	public User getAccount(Principal principal){
		User account = userServices.returnUserByUsername(principal.getName());
		return account;
	}
	
	@ModelAttribute("friend")
	public User getFriend() {
		return new User();
	}
	
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String helloUser() {
		return "dashboard";
	}
	
	
	@RequestMapping(value ="/friends", method = RequestMethod.GET)
	public String showFriends(@ModelAttribute("accounts")Account account, ModelMap model) {
		model.addAttribute("friends", userServices.returnFriendsByUsername(account.getUsername()));
		return "friends";
	}
	
	@RequestMapping(value="/friends/add", method=RequestMethod.GET)
	public String addFriendForm(@RequestParam(value="username", required =false) String username, @ModelAttribute("friend") User friend, ModelMap model) {
		if(username != null) {
		friend.setUsername(username);
		}
		model.addAttribute("friendAccount", friend);
		return "add";
	}
	
	@RequestMapping(value = "/friends/add", method = RequestMethod.POST)
	public String addFriend(@ModelAttribute("accounts")Account account, @ModelAttribute("friend") User friend, ModelMap model) {
		if(userServices.returnFriendsByUsername(friend.getUsername()) == null) {
			return "redirect:/friends/add?error";
		}
		userServices.addFriend(account.getUsername(), friend.getUsername());
		return "redirect:/friends/add?complete";
		
	}
	
	
	
	
}
