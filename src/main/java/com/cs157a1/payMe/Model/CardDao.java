package com.cs157a1.payMe.Model;

import java.util.Collection;

import com.cs157a1.payMe.Entity.Card;
import com.cs157a1.payMe.Entity.User;


public interface CardDao {
	Collection<Card> returnAllInfo();
	
	Card returnCardByUsername(int cardNumber);
	
	void addCardToDB(Card Card);
	
	void deleteCard(int cardNumber);
	
	String returnCardNumber(int cardNumber);
	
	String returnCardName(int cardNumber);
	
	int returnCardCvvNumber(int cardNumber);

	void updateCard(Card Card);

	User returnUserOfcard(int cardNumber);
}
