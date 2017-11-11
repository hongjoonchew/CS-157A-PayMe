package com.cs157a1.payMe.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cs157a1.payMe.Entity.Account;

@Repository("mysql")
public class MySqlDao implements AccountsImpl {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static class AccountsRowMapper implements RowMapper<Account>{

		@Override
		public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
			Account account = new Account();
			account.setUsername(rs.getString("username"));
			account.setFirstName(rs.getString("first_name"));
			account.setLastName(rs.getString("last_name"));
			return account;
		}
	}

	@Override
	public Collection<Account> returnAllInfo() {
		final String sql = "SELECT username, first_name, last_name FROM Accounts";
		Collection<Account> accounts =jdbcTemplate.query(sql, new AccountsRowMapper());
		return accounts;
	}

	@Override
	public Account returnAccountByUsername(String username) {
		final String sql = "SELECT username, first_name, last_name FROM Accounts where username = ?";
		Account account = jdbcTemplate.queryForObject(sql, new AccountsRowMapper(), username);
		return account;
	}

	@Override
	public void updateAccount(Account account) {
		final String sql = "UPDATE Users SET balance = ? WHERE username = ?";
		String username = account.getUsername();
		double balance = account.getPayMeBalance();
		jdbcTemplate.update(sql, new Object[] {balance, username});
	}

	@Override
	public void addAccountToDB(Account account) {
		final String sql = "INSERT INTO Accounts (username, password, first_name, last_name, email, enabled) VALUES (?,?,?,?,?,?)";
		final String userSQL = "INSERT INTO users (username, balance) VALUES (?,?)";
		final String accessSQL = "INSERT INTO AccessControl(username, authorities) VALUES (?,?)";
		String username = account.getUsername();
		String first_name = account.getFirstName();
		String last_name = account.getLastName();
		String password = account.getPassword();
		String email = account.getEmail();
		int enabled = 1;
		int balance = 0;
		jdbcTemplate.update(sql,new Object[] {username, password, first_name, last_name, email, enabled});
		jdbcTemplate.update(userSQL, new Object[] {username,balance});
		jdbcTemplate.update(accessSQL, new Object[] {username,1});

	}

	@Override
	public void deleteAccount(String username) {
		final String sql = "DELETE FROM Accounts WHERE username = ?";
		jdbcTemplate.update(sql,username);
	}

	
	@Override
	public String returnPassword(String username) {
		final String sql = "SELECT username, password FROM Accounts WHERE username = ?";
		Account account = jdbcTemplate.queryForObject(sql, new AccountsRowMapper(), username);
		return account.getPassword();
	}

	@Override
	public Collection<Account> returnFriendsByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
