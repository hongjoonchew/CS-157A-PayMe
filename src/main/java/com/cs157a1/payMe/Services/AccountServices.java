package com.cs157a1.payMe.Services;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cs157a1.payMe.Entity.Account;
import com.cs157a1.payMe.Model.AccountsImpl;

@Service
public class AccountServices {
	@Autowired
	@Qualifier("mysql")
	private AccountsImpl userAccount;
	
	public Collection<Account> returnAllInfo(){
		return userAccount.returnAllInfo();
	}
	
	public Account returnAccountByUsername(String username) {
		return userAccount.returnAccountByUsername(username);
	}
	
	public void updateAccount(Account account) {
		userAccount.updateAccount(account);
	}
	
	public void addAccounttoDB(Account account) {
		userAccount.addAccountToDB(account);
	}
	
	public void deleteAccount(String username) {
		userAccount.deleteAccount(username);
	}

	
}
