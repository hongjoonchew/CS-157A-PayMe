package com.cs157a1.payMe.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cs157a1.payMe.Entity.Comment;
import com.cs157a1.payMe.Entity.TransType;
import com.cs157a1.payMe.Entity.Transactions;



@Repository("TransactionsDao")
public class TransactionsDaoImpl implements TransactionsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Transactions> returnAllInfo() {
		return jdbcTemplate.query("select Transactions.transId, Transactions.amount, Comments.commentId, Comments.description" + 
				" from Transactions " + 
				" JOIN Comments on Transactions.transId=Comments.Transactions_transId", new TransactionsResultSetExtractor());
	}

	@Override
	public Transactions returnTransactionsBytransID(int transID) {
		final String sql = "select * from Transactions where transId = ?";
		return jdbcTemplate.queryForObject(sql, new TransactionsRowMapper(), transID);
		
	}

	@Override
	public void addTransactionsToDB(Transactions transaction) {
		final String sql = "BEGIN;"
				+ "INSERT INTO Transactions(type,amount) VALUES (?,?)"
				+ "INSERT INTO ";
		double amount = transaction.getAmount();
		TransType type = transaction.getType();
		String typeStr = (type==TransType.REQUEST) ? "Request" : "Transfer";
		jdbcTemplate.update(sql, new Object[] {typeStr,amount});		
	}

	@Override
	public void deleteTransactions(int transID) {
		final String sql = "DELETE FROM Transactions WHERE transId = ?";
		jdbcTemplate.update(sql,transID);
	}
	
	
	public class TransactionsResultSetExtractor implements ResultSetExtractor<List<Transactions>> {

		   @Override
		   public List<Transactions> extractData(ResultSet rs) throws SQLException {
		         Map<Integer, Transactions> transactionmap = new HashMap<Integer, Transactions>();
		         while (rs.next()) {
		             int id = rs.getInt("transID");
		             Transactions transaction = transactionmap.get(id);
		             if(transaction == null) {
		            	     transaction = new Transactions();
		   		    	     transaction.setTransID(rs.getInt("transID"));
				    	     transaction.setAmount(rs.getDouble("amount"));
				    	     transactionmap.put(rs.getInt("transID"), transaction);
		             }

					 Comment comment = new Comment();
					 comment.setCommentId(rs.getInt("commentId"));
					 comment.setDescription(rs.getString("description"));
					 
					 transaction.getComments().add(comment);
					  
		         }
		
		    	return new ArrayList<Transactions>(transactionmap.values());
			   
		  }
	}
	
	private static class TransactionsRowMapper implements RowMapper<Transactions>{
		  
		@Override
		public Transactions mapRow(ResultSet rs, int rowNum) throws SQLException {
			Transactions transactions = new Transactions();
	    	    transactions.setTransID(rs.getInt("transID"));
	    	    transactions.setAmount(rs.getDouble("amount"));
	
			return transactions;
		}
	}


}
