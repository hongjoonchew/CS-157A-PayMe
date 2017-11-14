package com.cs157a1.payMe.Model;

import java.util.Collection;

import com.cs157a1.payMe.Entity.User;
import com.cs157a1.payMe.Entity.creditCard;

public interface CreditCardDao {
	Collection<creditCard> returnAllInfo();
	
	creditCard returncreditCardBycardNumber(int cardNumber);
	
	void addcreditCardToDB(creditCard creditCard);
	
	void deletecreditCard(int cardNumber);
	
	String returnCardNumber(int cardNumber);
	
	String returnCardName(int cardNumber);
	
	int returnCardCvvNumber(int cardNumber);
	
	float returnCreditLimit(int cardNumber);

	void updatecreditCard(creditCard creditCard);

	User returnUserOfCreditCard(int cardNumber);
}
