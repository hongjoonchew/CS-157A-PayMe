package com.cs157a1.payMe.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cs157a1.payMe.Entity.Transactions;
import com.cs157a1.payMe.Entity.User;
import com.cs157a1.payMe.Services.TransactionsServices;
import com.cs157a1.payMe.Services.UsersServices;

@RestController
public class TestController {

	@Autowired
	private UsersServices userService;
	
	@Autowired
	private TransactionsServices transService;
	
	@RequestMapping("/test/return")
	public User returnTestInfo() {
		return userService.returnUserByUsername("David_Couch");
	}
	
	@RequestMapping("/test/returnList")
	public List<User> returnFriendList() {
		return userService.returnFriendsByUsername("David_Couch");
	}
	
	@RequestMapping("/test/comments")
	public List<User> returnAllComments(){
		return userService.returnComments("Dcouch");
	}
	
	@RequestMapping("/test/history")
	public List<Transactions> returnAllTransactions(){
		return transService.returnUsersRequest("REQUEST", "Hong_Joon");
	}
}
