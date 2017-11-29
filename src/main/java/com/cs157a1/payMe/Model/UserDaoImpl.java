package com.cs157a1.payMe.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cs157a1.payMe.Entity.Account;
import com.cs157a1.payMe.Entity.Card;
import com.cs157a1.payMe.Entity.Comment;
import com.cs157a1.payMe.Entity.Transactions;
import com.cs157a1.payMe.Entity.User;
import com.cs157a1.payMe.Model.MySqlDao.AccountsRowMapper;

import javax.sql.DataSource;


@Repository("UserDao")
public class UserDaoImpl implements UserDao  {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
		
	@Override
	public List<User> returnAllInfo() {
		 return jdbcTemplate.query("select User.username, User.balance, Account.first_name, Account.last_name from User JOIN Accounts on User.username=Accounts.username", new UserResultSetExtractor());
	}
	
	
	@Override
	public  User returnUserByUsername(String username) {
		final String sql = "select User.username, User.balance, Account.first_name, Account.last_name from Users"
				+ "JOIN Accounts on User.username=Accounts.username"
				+ "where username = ?";
		User user = jdbcTemplate.queryForObject(sql, new UsersRowMapper(), username);
		
		return user;
	}
	

	@Override
	public void addUserToDB(User user) {
		final String accountsql = "INSERT INTO Accounts (username, password, first_name, last_name, email, enabled) VALUES (?,?,?,?,?,?)";
		final String userSQL = "INSERT INTO users (username, balance) VALUES (?,?)";
		
		String username = user.getUsername();
		String first_name = user.getFirstName();
		String last_name = user.getLastName();
		String password = user.getPassword();
		String email = user.getEmail();
		int enabled = 1;
		int balance = 0;
		
		jdbcTemplate.update(accountsql,new Object[] {username, password, first_name, last_name, email, enabled});
		jdbcTemplate.update(userSQL, new Object[] {username,balance});
	}

	@Override
	public void deleteUser(String username) {
		final String sql = "DELETE FROM Users WHERE username = ?";
		final String sql_account = "DELETE FROM Accounts WHERE username = ?";
		
		jdbcTemplate.update(sql,username);
		jdbcTemplate.update(sql_account,username);	

	}

	@Override
	public String returnPassword(String username) {
		final String sql = "SELECT username, password FROM Accounts WHERE username = ?";
		Account account = jdbcTemplate.queryForObject(sql, new AccountsRowMapper(), username);
		return account.getPassword();
	}

	@Override
	public double returnBalance(String username) {
		final String sql = "SELECT username, balance FROM Users WHERE username = ?";
		User user = jdbcTemplate.queryForObject(sql, new UsersRowMapper(), username);
		return user.getBalance();
	}

	@Override
	public void updateUser(User user) {
		// todo
		// update account
		final String sql = "UPDATE Users SET balance = ? WHERE username = ?";
		String username = user.getUsername();
		double balance = user.getBalance();
		jdbcTemplate.update(sql, new Object[] {balance, username});
	}

	@Override
	public List<User> returnFriendsByUsername(String username) {
		return jdbcTemplate.query("select Users.username, Users.balance, Accounts.first_name, Accounts.last_name, "
				+ " UserF.username as usernameF, UserF.balance as balanceF,AccountsF.firstname as firstnameF, Accounts.last_name as last_nameF"
				   + "JOIN Accounts on Users.username=Accounts.username"
		           + "JOIN users_has_users on User.username=users_has_users.username"
		           + "JOIN Users UserF on users_has_users.username=Users.username"
		           + "JOIN Accounts AccountsF on Users.username=Accounts.username ", new UserFriendsExtractor());
	}

	@Override
	public List<User> returnComments(String username) {
		return jdbcTemplate.query("select User.username, User.balance, Account.first_name, Account.last_name, "
				           + "Comments.commentId , Comments.description from User "
				           + "JOIN Accounts on User.username=Accounts.username "
				           + "JOIN Comments on User.username= Comments.users_username", new UserCommentsExtractor());

	}

	@Override
	public List<User> returnTransactions(String username) {
		return  jdbcTemplate.query("select User.username, User.balance, Account.first_name, Account.last_name from User "
				+ "Transactions.transId, Transactions.amount"
				+ "JOIN Accounts on User.username=Accounts.username "
				+ "JOIN users_has_Transactions on User.username = users_has_Transactions.sender_username"
				+ "JOIN Transactions on users_has_Transactions.transId=Transactions.transId "
				+ "where username = ? ", new UserTransactionsExtractor());

	}


	@Override
	public User returnCardBelongToUser(String username) {

		return  jdbcTemplate.queryForObject("select User.username, User.balance, Account.first_name, Account.last_name from User "
				+ "Transactions.transId, Transactions.amount"
				+ "JOIN Accounts on User.username=Accounts.username "
				+ "JOIN Cards on User.username=Cards.username"
				+ "JOIN debtCard on Cards.number=debtCard.number"
				+ "where username = ?", new UsersCardRowMapper(), username);

	}
	
	public class UserFriendsExtractor implements ResultSetExtractor<List<User>>{

	    @Override
	    public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
	         Map<String, User> usermap = new HashMap<String, User>();
	         while (rs.next()) {
	             String username = rs.getString("username");
	             User user = usermap.get(username);
	             if(user == null) {
			         user = new User();
					 user.setUsername(rs.getString("username"));
					 user.setBalance(rs.getDouble("balance"));
					 user.setFirstName(rs.getString("first_name"));
					 user.setLastName(rs.getString("last_name"));
					 usermap.put(rs.getString("username"), user);
	             }

				 User friend = new User() ;
				 friend.setUsername(rs.getString("usernameF"));
				 friend.setBalance(rs.getDouble("balanceF"));
				 friend.setFirstName(rs.getString("first_nameF"));
				 friend.setLastName(rs.getString("last_nameF")); 
				 user.getFriends().add(friend);
	        	 
	         }
	
	    	return new ArrayList<User>(usermap.values());
	    }
	}
	
	public class UserTransactionsExtractor implements ResultSetExtractor<List<User>>{

	    @Override
	    public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
	         Map<String, User> usermap = new HashMap<String, User>();
	         while (rs.next()) {
	             String username = rs.getString("username");
	             User user = usermap.get(username);
	             if(user == null) {
			         user = new User();
					 user.setUsername(rs.getString("username"));
					 user.setBalance(rs.getDouble("balance"));
					 user.setFirstName(rs.getString("first_name"));
					 user.setLastName(rs.getString("last_name"));
					 usermap.put(rs.getString("username"), user);
	             }

				 Transactions transaction = new Transactions();
				 transaction.setTransID(rs.getInt("transId"));
				 transaction.setAmount(rs.getDouble("amount"));						 
				 user.getTransactions().add(transaction);
	        	 
	         }
	
	    	return new ArrayList<User>(usermap.values());
	    	
	    }
	}
	
	
	public class UserCommentsExtractor implements ResultSetExtractor<List<User>>{

	    @Override
	    public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
	         Map<String, User> usermap = new HashMap<String, User>();
	         while (rs.next()) {
	             String username = rs.getString("username");
	             User user = usermap.get(username);
	             if(user == null) {
			         user = new User();
					 user.setUsername(rs.getString("username"));
					 user.setBalance(rs.getDouble("balance"));
					 user.setFirstName(rs.getString("first_name"));
					 user.setLastName(rs.getString("last_name"));
					 usermap.put(rs.getString("username"), user);
	             }

				 Comment comment = new Comment();
				 comment.setCommentId(rs.getInt("commentId"));
				 comment.setDescription(rs.getString("description"));
				 
				 user.getComments().add(comment);
	        	 
	         }
	
	    	return new ArrayList<User>(usermap.values());
	    	
	    }
	}
	
	private static class UsersCardRowMapper implements RowMapper<User>{
		  
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setUsername(rs.getString("username"));
			user.setBalance(rs.getDouble("balance"));
			 user.setFirstName(rs.getString("first_name"));
			 user.setLastName(rs.getString("last_name"));
			return user;
		}
	}
	
	public class UserResultSetExtractor implements ResultSetExtractor<List<User>> {

		   @Override
		   public List<User> extractData(ResultSet rs) throws SQLException {
		      List<User> userlist = new ArrayList<User>();      
		      while(rs.next()){
		         User user = new User();
				 user.setUsername(rs.getString("username"));
				 user.setBalance(rs.getDouble("balance"));
				 user.setFirstName(rs.getString("first_name"));
				 user.setLastName(rs.getString("last_name"));
				 
		         userlist.add(user);
		      }
		      return userlist;
		  }
		}
	
	private static class UsersRowMapper implements RowMapper<User>{
		  
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setUsername(rs.getString("username"));
			user.setBalance(rs.getDouble("balance"));
			 user.setFirstName(rs.getString("first_name"));
			 user.setLastName(rs.getString("last_name"));
			return user;
		}
	}
	

}
