package com.cs157a1.payMe.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cs157a1.payMe.Services.AccountServices;

@RestController
@RequestMapping()
public class AccountController {
	@Autowired
	private AccountServices accountServices;
	
	@RequestMapping(method = RequestMethod.GET)
	public String[] returnAllInfo() {
		return accountServices.getAccountInfo();
	}
}
