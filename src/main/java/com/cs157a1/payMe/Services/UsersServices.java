package com.cs157a1.payMe.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.*;

import com.cs157a1.payMe.Entity.User;
import com.cs157a1.payMe.Model.UserDao;

@Service
public class UsersServices {
	
	@Autowired
	@Qualifier("mysql")
	private UserDao userDao;
	
	List<User> returnAllInfo(){
		return userDao.returnAllInfo();
	}

	User returnUserByUsername(String username) {
		return userDao.returnUserByUsername(username);
	}

	void addUserToDB(User User) {
		 userDao.addUserToDB(User);
	}

	void deleteUser(String username) {
		 userDao.deleteUser(username);
	}

	String returnPassword(String username) {
		return userDao.returnPassword(username);
	}

	double returnBalance(String username) {
		return userDao.returnBalance(username);
	}

	void updateUser(User User) {
		 userDao.updateUser(User);
	}

	List<User> returnFriendsByUsername(String username){
		return userDao.returnFriendsByUsername(username);
	}

	List<User> returnComments(String username){
		return userDao.returnComments(username);
	}

	List<User> returnTransactions(String username){
		return userDao.returnTransactions(username);
	}

	User returnCardBelongToUser(String username) {
		return userDao.returnCardBelongToUser(username);
	}
}
