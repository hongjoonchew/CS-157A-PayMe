package com.cs157a1.payMe.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.*;

import com.cs157a1.payMe.Entity.Transactions;
import com.cs157a1.payMe.Model.TransactionsDao;

@Service
public class TransactionsServices {
	
	@Autowired
	@Qualifier("TransactionsDao")
	private TransactionsDao transactionsDao;
	
	
	public List<Transactions> returnAllInfo(){
		return transactionsDao.returnAllInfo();
		
	}
	
	public List<Transactions> returnUsersRequest(String type, String username){
		return transactionsDao.returnUsersRequest(type,username);
	}
	
	public List<Transactions> returnUsersTransfers(String type, String username){
		return transactionsDao.returnUsersTransfers(type,username);
	}
	
	public Transactions returnTransactionsBytransID(int transID) {
		return transactionsDao.returnTransactionsBytransID(transID);
	}
	
	public void addTransactionsToDB(Transactions transaction, String sender, String receiver) {
		 transactionsDao.addTransactionsToDB(transaction,sender,receiver);
	}
	
	public void deleteTransactions(int transID) {
		 transactionsDao.deleteTransactions(transID);
	}
	
	public void deleteUserHasTransactions(int transId, String receiver) {
		transactionsDao.deleteUserHasTransactions(transId, receiver);
	}

}
