package com.cs157a1.payMe.Entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;


public class creditCard extends Card {
	
	@NotNull
	@NotBlank
	private float creditLimit;

	public creditCard(String cardNumber, String cardName, int cvvNumber, float creditLimit) {
		super(cardNumber, cardName, cvvNumber);
		this.creditLimit = creditLimit;
	}
	
	public float getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(float creditLimit) {
		this.creditLimit = creditLimit;
	}

	
}
