package com.cs157a1.payMe.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.cs157a1.payMe.Entity.Card;
import com.cs157a1.payMe.Entity.Comment;
import com.cs157a1.payMe.Entity.Transactions;
import com.cs157a1.payMe.Entity.User;

public interface UserDao {
	Collection<User> returnAllInfo();

	User returnUserByUsername(String username);

	void addUserToDB(User User);

	void deleteUser(String username);

	String returnPassword(String username);

	double returnBalance(String username);

	void updateUser(User User);

	Collection<User> returnFriendsByUsername(String username);

	Collection<Comment> returnComments(String username);

	Collection<Transactions> returnTransactions(String username);

	Card returnCardBelongToUser(String username);

}
