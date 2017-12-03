package com.cs157a1.payMe.Entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class Account {

	@NotNull
	@NotBlank
	private String firstName;
	@NotNull
	@NotBlank
	private String lastName;
	@NotNull
	@NotBlank
	private String username;
	@NotNull
	@NotBlank
	private String password;
	@NotNull
	@NotBlank
	private String email;

	public Account() {
	}

	public Account(String firstName, String lastName, String username, String password,
			String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.setPassword(password);
		this.email = email;
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
