package com.cs157a1.payMe.Model;

import java.util.Collection;

import com.cs157a1.payMe.Entity.Account;

public interface AccountsImpl {

	Collection<Account> returnAllInfo();
	
	Account returnAccountByUsername(String username);
	
	
	void addAccountToDB(Account account);
	
	void deleteAccount(String username);
	
	String returnPassword(String username);

	void updateAccount(Account account);

	Collection<Account> returnFriendsByUsername(String username);

}