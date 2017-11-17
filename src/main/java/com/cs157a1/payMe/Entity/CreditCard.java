package com.cs157a1.payMe.Entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

public class CreditCard extends Card {

	@NotNull
	@NotBlank
	private float creditLimit;
	
	CardType type;

	public CreditCard() {
	}

	public CreditCard(String cardNumber, String cardName, int cvvNumber, float creditLimit) {
		super(cardNumber, cardName, cvvNumber);
		this.creditLimit = creditLimit;
		type = CardType.Credit;
	}

	public CreditCard(String cardNumber, String cardName, int cvvNumber, float creditLimit, User user) {
		super(cardNumber, cardName, cvvNumber, user);
		this.creditLimit = creditLimit;
		type = CardType.Credit;
	}

	public float getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(float creditLimit) {
		this.creditLimit = creditLimit;
	}

}
