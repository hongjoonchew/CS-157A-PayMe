package com.cs157a1.payMe.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cs157a1.payMe.Entity.Account;
import com.cs157a1.payMe.Services.AccountServices;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	@Autowired
	private AccountServices accountServices;
	
	@RequestMapping(method = RequestMethod.GET)
	public Collection<Account> returnAllInfo() {
		return accountServices.returnAllInfo();
	}
	
	@RequestMapping(value = "/{username}",method = RequestMethod.GET)
	public Account returnAccountbyUsername(@PathVariable("username")String username) {
		return accountServices.returnAccountByUsername(username);
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