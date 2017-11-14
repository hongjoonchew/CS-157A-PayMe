package com.cs157a1.payMe.Model;

import java.util.Collection;

import com.cs157a1.payMe.Entity.Transactions;
import com.cs157a1.payMe.Entity.Comment;
import com.cs157a1.payMe.Entity.User;
import com.cs157a1.payMe.Entity.TransType;

public interface TransactionsDao {
	Collection<Transactions> returnAllInfo();
	
	Transactions returnTransactionsBytransID(int transID);
	
	void addTransactionsToDB(Transactions Transactions);
	
	void deleteTransactions(int transID);
	
	double returnamount(int transID);

	TransType returnType(int transID);

	void updateTransactions(Transactions Transactions);

	Collection<Comment> returnCommentsFromTransaction(int transID);
	
	User returnTransactionSender(int transID);
	
	User returnTransactionReciever(int transID);

}
