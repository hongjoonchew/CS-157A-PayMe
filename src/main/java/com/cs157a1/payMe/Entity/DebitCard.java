package com.cs157a1.payMe.Entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

public class DebitCard extends Card {

	

	@NotNull
	@NotBlank
	private float balance;
	
	CardType type;

	public DebitCard() {
	}

	public DebitCard(String cardNumber, String cardName, int cvvNumber, float balance) {
		super(cardNumber, cardName, cvvNumber);
		this.balance = balance;
		type = CardType.Debit;
	}

	public DebitCard(String cardNumber, String cardName, int cvvNumber, float balance, User user) {
		super(cardNumber, cardName, cvvNumber, user);
		this.balance = balance;
		type = CardType.Debit;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

}
