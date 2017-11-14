package com.cs157a1.payMe.Entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

public class Comment {

	@NotNull
	@NotBlank
	private int commentId;
	@NotNull
	@NotBlank
	private String description;

	private User user;
	private Transactions transactions;

	public Comment(int commentId, String description) {
		this.commentId = commentId;
		this.description = description;
	}

	public Comment(int commentId, String description, User user, Transactions transactions) {
		this.commentId = commentId;
		this.description = description;
		this.user = user;
		this.transactions = transactions;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Transactions getTransactions() {
		return transactions;
	}

	public void setTransactions(Transactions transactions) {
		this.transactions = transactions;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
