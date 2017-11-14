package com.cs157a1.payMe.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cs157a1.payMe.Entity.Card;
import com.cs157a1.payMe.Entity.Comment;
import com.cs157a1.payMe.Entity.Transactions;
import com.cs157a1.payMe.Entity.User;


@Repository("UserDao")
public class UserDaoImpl implements UserDao {

	@Override
	public Collection<User> returnAllInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User returnUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUserToDB(User User) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String returnPassword(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double returnBalance(String username) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateUser(User User) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<User> returnFriendsByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Comment> returnComments(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Transactions> returnTransactions(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Card returnCardBelongToUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
