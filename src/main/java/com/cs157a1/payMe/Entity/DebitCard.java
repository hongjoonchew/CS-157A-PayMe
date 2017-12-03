package com.cs157a1.payMe.Entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

public class DebitCard extends Card {

	@NotNull
	@NotBlank
	private float balance;
	
	@NotNull
	@NotBlank
	private String type;

	public DebitCard() {
	}

	public DebitCard(long cardNumber, String cardName, int cvvNumber, float balance) {
		super(cardNumber, cardName, cvvNumber);
		this.balance = balance;
	}

	public DebitCard(long cardNumber, String cardName, int cvvNumber, float balance, User user) {
		super(cardNumber, cardName, cvvNumber, user);
		this.balance = balance;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

}
