package com.cs157a1.payMe.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.*;

import com.cs157a1.payMe.Entity.Card;
import com.cs157a1.payMe.Entity.User;
import com.cs157a1.payMe.Model.UserDao;

@Service
public class UsersServices {
	
	@Autowired
	@Qualifier("UserDao")
	private UserDao userDao;
	
	public List<User> returnAllInfo(){
		return userDao.returnAllInfo();
	}

	public User returnUserByUsername(String username) {
		return userDao.returnUserByUsername(username);
	}
	
	public 	String cardTypeByCardNumber(int cardNumber) {
		return userDao.cardTypeByCardNumber(cardNumber);
	}

	public void addUserToDB(User User) {
		 userDao.addUserToDB(User);
	}
	
	public void addFriend(String usename,String friendusername) {
		userDao.addFriend(usename, friendusername);
	}

	public void deleteUser(String username) {
		 userDao.deleteUser(username);
	}

	public String returnPassword(String username) {
		return userDao.returnPassword(username);
	}

	public double returnBalance(String username) {
		return userDao.returnBalance(username);
	}

	public void updateUser(User User) {
		 userDao.updateUser(User);
	}

	public List<User> returnFriendsByUsername(String username){
		List<User> friendsListOne = userDao.returnFriendsByUsernameColumnOne(username);
		List<User> friendsListTwo = userDao.returnFriendsByUsernameColumnTwo(username);
		friendsListOne.addAll(friendsListTwo);
		return friendsListOne;
	}

	public List<User> returnComments(String username){
		return userDao.returnComments(username);
	}

	public List<User> returnTransactions(String username){
		return userDao.returnTransactions(username);
	}

	public List<Card> returnCardBelongToUser(String username) {
		return userDao.returnCardBelongToUser(username);
	}
}
