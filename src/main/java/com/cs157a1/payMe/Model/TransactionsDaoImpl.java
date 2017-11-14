package com.cs157a1.payMe.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cs157a1.payMe.Entity.Comment;
import com.cs157a1.payMe.Entity.TransType;
import com.cs157a1.payMe.Entity.Transactions;
import com.cs157a1.payMe.Entity.User;


@Repository("TransactionsDao")
public class TransactionsDaoImpl implements TransactionsDao {

	@Override
	public Collection<Transactions> returnAllInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transactions returnTransactionsBytransID(int transID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTransactionsToDB(Transactions Transactions) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTransactions(int transID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double returnamount(int transID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TransType returnType(int transID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateTransactions(Transactions Transactions) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Comment> returnCommentsFromTransaction(int transID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User returnTransactionSender(int transID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User returnTransactionReciever(int transID) {
		// TODO Auto-generated method stub
		return null;
	}

}
