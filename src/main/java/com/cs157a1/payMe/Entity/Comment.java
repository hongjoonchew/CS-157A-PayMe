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
	
	
	public Comment(int commentId, String description) {
		this.commentId = commentId;
		this.description = description;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
