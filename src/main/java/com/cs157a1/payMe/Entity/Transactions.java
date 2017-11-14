package com.cs157a1.payMe.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class Transactions {

	@NotNull
	@NotBlank
	private int transID;
	@NotNull
	@NotBlank
	private TransType type;
	@NotNull
	@Digits(integer = 8, fraction = 2)
	@NotBlank
	private double amount;

	private User sender;
	private User receiver;
	private List<Comment> comments = new ArrayList<Comment>();

	public Transactions() {
	}

	public Transactions(int transID, TransType type, double amount) {
		this.transID = transID;
		this.type = type;
		this.amount = amount;
	}

	public Transactions(int transID, TransType type, double amount, List<Comment> comments, User sender,
			User receiver) {
		this.transID = transID;
		this.type = type;
		this.amount = amount;
		this.comments = comments;
		this.sender = sender;
		this.receiver = receiver;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public int getTransID() {
		return transID;
	}

	public void setTransID(int transID) {
		this.transID = transID;
	}

	public TransType getType() {
		return type;
	}

	public void setType(TransType type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
