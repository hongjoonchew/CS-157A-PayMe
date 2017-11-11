package com.cs157a1.payMe.Entity;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class Transactions {
	
	private int transID;
	private TransType type;
	@NotNull
	@Digits(integer=8,fraction=2)
	@NotBlank
	private double amount;
	
	public Transactions(int transID, TransType type, double amount) {
		this.transID = transID;
		this.type = type;
		this.amount = amount;
	}

	public int getTransID() {
		return transID;
	}

	public void setTransID(int transID) {
		this.transID = transID;
	}

	public TransType getType() {
		return type;
	}

	public void setType(TransType type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
}
