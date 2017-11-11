package com.cs157a1.payMe.Model;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.cs157a1.payMe.Entity.Account;

@Repository
public class AccountsModel implements AccountsImpl {
	private static Account[] accounts;
	
	
	/* (non-Javadoc)
	 * @see com.cs157a1.payMe.Model.AccountsImpl#returnAllInfo()
	 */
	@Override
	public Collection<Account> returnAllInfo() {
		return null;
	}

	@Override
	public Account returnAccountByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAccount(Account account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAccountToDB(Account account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccount(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String returnPassword(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Account> returnFriendsByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}
