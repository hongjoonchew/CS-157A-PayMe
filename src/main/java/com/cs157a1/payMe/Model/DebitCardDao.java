package com.cs157a1.payMe.Model;

import java.util.Collection;

import com.cs157a1.payMe.Entity.DebitCard;
import com.cs157a1.payMe.Entity.User;

public interface DebitCardDao {
	Collection<DebitCard> returnAllInfo();
	
	DebitCard returnDebitCardBycardNumber(int cardNumber);
	
	void addDebitCardToDB(DebitCard DebitCard);
	
	void deleteDebitCard(int cardNumber);
	
	String returnCardNumber(int cardNumber);
	
	String returnCardName(int cardNumber);
	
	int returnCardCvvNumber(int cardNumber);
	
	float returnBalance(int cardNumber);

	void updateDebitCard(DebitCard DebitCard);

	User returnUserOfDebitCard(int cardNumber);
}
