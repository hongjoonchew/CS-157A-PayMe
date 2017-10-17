package com.cs157a1.payMe.Entity;



public class Account {
	private String firstName;
	private String lastName;
	private String username;
	private int payMeBalance;
	@SuppressWarnings("unused")
	private String password;
	
	public Account(String firstName, String lastName, String username, int payMeBalance, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.payMeBalance = payMeBalance;
		this.password = password;
	}
	
	public Account() {}

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

	public int getPayMeBalance() {
		return payMeBalance;
	}

	public void setPayMeBalance(int payMeBalance) {
		this.payMeBalance = payMeBalance;
	}

	public String[] getFullInfo() {
		return new String[] {this.getFirstName(), this.getLastName(), this.getUsername(),String.valueOf(this.getPayMeBalance())};
	}
	
}
