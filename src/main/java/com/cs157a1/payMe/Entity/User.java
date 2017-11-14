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

	public User() {
	}

	public User(String firstName, String lastName, String username, int payMeBalance, String password, String email,
			double balance) {
		super(firstName, lastName, username, payMeBalance, password, email);
		this.balance = balance;
	}

	public User(String firstName, String lastName, String username, int payMeBalance, String password, String email,
			double balance, List<User> friends, List<Comment> comments, List<Transactions> transactions, Card card) {
		super(firstName, lastName, username, payMeBalance, password, email);
		this.balance = balance;
		this.friends = friends;
		this.comments = comments;
		this.transactions = transactions;
		this.card = card;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Transactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
