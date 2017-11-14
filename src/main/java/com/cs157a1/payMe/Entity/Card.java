package com.cs157a1.payMe.Entity;

public class Card {
	private String cardNumber;
	private String cardName;
	private int cvvNumber;

	private User user;

	public Card() {
	}

	public Card(String cardNumber, String cardName, int cvvNumber) {
		super();
		this.cardNumber = cardNumber;
		this.cardName = cardName;
		this.cvvNumber = cvvNumber;
	}

	public Card(String cardNumber, String cardName, int cvvNumber, User user) {
		super();
		this.cardNumber = cardNumber;
		this.cardName = cardName;
		this.cvvNumber = cvvNumber;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public int getCvvNumber() {
		return cvvNumber;
	}

	public void setCvvNumber(int cvvNumber) {
		this.cvvNumber = cvvNumber;
	}
}
