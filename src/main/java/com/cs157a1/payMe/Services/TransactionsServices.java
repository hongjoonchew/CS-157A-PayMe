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
	@Qualifier("mysql")
	private TransactionsDao transactionsDao;
	
	
	List<Transactions> returnAllInfo(){
		return transactionsDao.returnAllInfo();
		
	}
	
	Transactions returnTransactionsBytransID(int transID) {
		return transactionsDao.returnTransactionsBytransID(transID);
	}
	
	void addTransactionsToDB(Transactions Transactions) {
		 transactionsDao.addTransactionsToDB(Transactions);
	}
	
	void deleteTransactions(int transID) {
		 transactionsDao.deleteTransactions(transID);
	}

}
