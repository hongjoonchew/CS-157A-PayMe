package com.cs157a1.payMe.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs157a1.payMe.Entity.Account;
import com.cs157a1.payMe.Model.AccountsModel;

@Service
public class AccountServices {
	@Autowired
	private AccountsModel userAccount;
	
	public String[] getAccountInfo() {
		Account[] accounts = userAccount.returnAllInfo();
		String[] accountInfo = new String[accounts.length];
		for(int i =0; i < accounts.length; i++) {
			accountInfo[i]=accounts[i].getFirstName();
		}
		return accountInfo;
	}
	
}
