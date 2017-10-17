package com.cs157a1.payMe.Model;

import org.springframework.stereotype.Repository;

import com.cs157a1.payMe.Entity.Account;

@Repository
public class AccountsModel {
	private static Account[] accounts;
	
	static {
		accounts = new Account[3]; 
		accounts[0]=new Account("First","Last","User",1000,"secret");
		accounts[1]=new Account("First","Last","User",1000, "secret");
		accounts[2]=new Account("First","Last","User",1000, "secret");
		
	}
	
	public Account[] returnAllInfo() {
		return accounts;
	}
}
