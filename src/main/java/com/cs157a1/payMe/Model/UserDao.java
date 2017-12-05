package com.cs157a1.payMe.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.cs157a1.payMe.Entity.Card;
import com.cs157a1.payMe.Entity.Comment;
import com.cs157a1.payMe.Entity.Transactions;
import com.cs157a1.payMe.Entity.User;

public interface UserDao {
	List<User> returnAllInfo();

	User returnUserByUsername(String username);

	void addUserToDB(User User);
	
	void addFriend(String usename,String friendusername);

	void deleteUser(String username);

	String returnPassword(String username);

	double returnBalance(String username);

	void updateUser(User User);
	
	String cardTypeByCardNumber(int cardNumber);

	List<User> returnFriendsByUsernameColumnOne(String username);
	
	List<User> returnFriendsByUsernameColumnTwo(String username);

	List<User> returnComments(String username);

	List<User> returnTransactions(String username);

	List<Card> returnCardBelongToUser(String username);

}
