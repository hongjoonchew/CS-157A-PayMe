package com.cs157a1.payMe.Entity;

import java.util.*;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

public class User extends Account {
	
	@NotNull
	@NotBlank
	private double balance;
	
	private List<User> friends = new ArrayList<User>();
	private List<Comment> comments = new ArrayList<Comment>();
	private List<Transactions> transactions = new ArrayList<Transactions>();
	private Card card;

	public User(String firstName, String lastName, String username, int payMeBalance, String password, String email,double balance) {
		super(firstName, lastName, username, payMeBalance, password, email);
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
