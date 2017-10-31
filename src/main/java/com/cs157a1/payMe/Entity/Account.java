package com.cs157a1.payMe.Entity;



public class Account {
	private String firstName;
	private String lastName;
	private String username;
	private double payMeBalance;
	private String password;
	private String email;
	
	public Account(String firstName, String lastName, String username, int payMeBalance, String password, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.payMeBalance = payMeBalance;
		this.setPassword(password);
		this.email = email;
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

	public double getPayMeBalance() {
		return payMeBalance;
	}

	public void setPayMeBalance(double d) {
		this.payMeBalance = d;
	}

	public String[] getFullInfo() {
		return new String[] {this.getFirstName(), this.getLastName(), this.getUsername(),String.valueOf(this.getPayMeBalance())};
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
