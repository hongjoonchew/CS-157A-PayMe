
package com.cs157a1.payMe.Entity;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

public class CreditCard extends Card {

	@NotNull
	@NotBlank
	private float creditLimit;
	
	@NotNull
	@NotBlank
	private String issuer;
	
	public CreditCard() {
	}
	
	public CreditCard(Card card, float creditLimit) {
		super(card);
		this.creditLimit=creditLimit;
	}

	public CreditCard(long cardNumber, String cardName, int cvvNumber, float creditLimit) {
		super(cardNumber, cardName, cvvNumber);
		this.creditLimit=creditLimit;
	}

	public CreditCard(long cardNumber, String cardName, int cvvNumber, float creditLimit, User user) {
		super(cardNumber, cardName, cvvNumber, user);
		this.creditLimit=creditLimit;
	}
	
	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public float getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(float creditLimit) {
		this.creditLimit = creditLimit;
	}

}
