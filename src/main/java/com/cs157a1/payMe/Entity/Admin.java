package com.cs157a1.payMe.Entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

public class Admin extends Account {

	@NotNull
	@NotBlank
	private int authorities;

	public Admin() {
	}

	public Admin(String firstName, String lastName, String username, int payMeBalance, String password, String email,
			int authorities) {
		super(firstName, lastName, username, payMeBalance, password, email);
		this.authorities = authorities;
	}

	public int getAuthorities() {
		return authorities;
	}

	public void setAuthorities(int authorities) {
		this.authorities = authorities;
	}
}
