package com.cs157a1.payMe.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cs157a1.payMe.Services.AccountServices;

@RestController
@RequestMapping("/signup")
public class SignUpController {
	private AccountServices accountServices;
	
	
	
	@RequestMapping(method = RequestMethod.PUT)
	public void addAccountToDB() {
		
	}
	
}
