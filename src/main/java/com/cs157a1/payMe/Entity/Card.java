package com.cs157a1.payMe.Entity;

public class Card {
	private long cardNumber;
	private String cardName;
	private int cvvNumber;
	private int expiration_year;
	private int expiration_month;

	private User user;

	public Card() {
	}

	public Card(long cardNumber, String cardName, int cvvNumber) {
		super();
		this.cardNumber = cardNumber;
		this.cardName = cardName;
		this.cvvNumber = cvvNumber;
	}

	public Card(long cardNumber, String cardName, int cvvNumber, User user) {
		super();
		this.cardNumber = cardNumber;
		this.cardName = cardName;
		this.cvvNumber = cvvNumber;
		this.user = user;
	}
	
	public int getExpiration_year() {
		return expiration_year;
	}

	public void setExpiration_year(int expiration_year) {
		this.expiration_year = expiration_year;
	}

	public int getExpiration_month() {
		return expiration_month;
	}

	public void setExpiration_month(int expiration_month) {
		this.expiration_month = expiration_month;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
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
