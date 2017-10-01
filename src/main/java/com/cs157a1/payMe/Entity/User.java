package com.cs157a1.payMe.Entity;

public class User {
	private String firstName;
	private String lastName;
	private String username;
	private String payMeBalance;
	
	public User(String firstName, String lastName, String username, String payMeBalance) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.payMeBalance = payMeBalance;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPayMeBalance() {
		return payMeBalance;
	}

	public void setPayMeBalance(String payMeBalance) {
		this.payMeBalance = payMeBalance;
	}

	
}
