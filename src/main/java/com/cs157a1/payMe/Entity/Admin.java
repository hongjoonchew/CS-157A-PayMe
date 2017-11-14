package com.cs157a1.payMe.Entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

public class Admin extends Account {

	@NotNull
	@NotBlank
	private String authorities;

	public Admin() {
	}

	public Admin(String firstName, String lastName, String username, int payMeBalance, String password, String email,
			String authorities) {
		super(firstName, lastName, username, payMeBalance, password, email);
		this.authorities = authorities;
	}

	public String getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}
}
