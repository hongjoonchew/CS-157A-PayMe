package com.cs157a1.payMe.Model;

import java.util.Collection;
import java.util.*;
import com.cs157a1.payMe.Entity.Transactions;
import com.cs157a1.payMe.Entity.Comment;
import com.cs157a1.payMe.Entity.User;
import com.cs157a1.payMe.Entity.TransType;

public interface TransactionsDao {
	List<Transactions> returnAllInfo();
	
	List<Transactions> returnUsersRequest(String type, String username);
	
	List<Transactions> returnUsersTransfers(String type, String username);
	
	Transactions returnTransactionsBytransID(int transID);
	
	void addTransactionsToDB(Transactions transaction, String sender, String receiver);
	
	void deleteTransactions(int transID);
	
	public void deleteUserHasTransactions(int transId, String receiver);
}
