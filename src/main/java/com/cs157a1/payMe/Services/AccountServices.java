package com.cs157a1.payMe.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs157a1.payMe.Entity.Account;

@Service
public class AccountServices {
	private Account userAccount;
	
	@Autowired
	public String[] getAccountInfo() {
		return userAccount.getFullInfo();
	}
	
}
