package com.cs157a1.payMe.Controller;

import java.security.Principal;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cs157a1.payMe.Entity.Account;
import com.cs157a1.payMe.Entity.User;
import com.cs157a1.payMe.Services.AccountServices;
import com.cs157a1.payMe.Services.UsersServices;

@Controller
@RequestMapping("/accounts")
@SessionAttributes("accounts")
public class AccountController {
	@Autowired
	private AccountServices accountServices;
	
	@Autowired
	private UsersServices userServices;
	
	@ModelAttribute("accounts")
	public User getAccount(Principal principal){
		User account = userServices.returnUserByUsername(principal.getName());
		return account;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public Collection<Account> returnAllInfo() {
		return accountServices.returnAllInfo();
	}
	
	@RequestMapping(value = "/{username}",method = RequestMethod.GET)
	public String returnAccountbyUsername(@PathVariable("username")String username, ModelMap map) {
		Account acc = accountServices.returnAccountByUsername(username);
		map.addAttribute("targetAccount", acc);
		return "{username}";
	}
	
	@RequestMapping(value = "/{username}",method = RequestMethod.DELETE)
	public void deleteAccount(@PathVariable("username")String username) {
		accountServices.deleteAccount(username);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void updateAccount(@RequestBody Account account) {
		accountServices.updateAccount(account);
	}
}