package com.cs157a1.payMe.Model;

import java.util.Collection;

import com.cs157a1.payMe.Entity.User;
import com.cs157a1.payMe.Entity.CreditCard;

public interface CreditCardDao {
	Collection<CreditCard> returnAllInfo();
	
	CreditCard returncreditCardBycardNumber(int cardNumber);
	
	void addcreditCardToDB(CreditCard creditCard);
	
	void deletecreditCard(int cardNumber);
	
	String returnCardNumber(int cardNumber);
	
	String returnCardName(int cardNumber);
	
	int returnCardCvvNumber(int cardNumber);
	
	float returnCreditLimit(int cardNumber);

	void updatecreditCard(CreditCard creditCard);

	User returnUserOfCreditCard(int cardNumber);
}
