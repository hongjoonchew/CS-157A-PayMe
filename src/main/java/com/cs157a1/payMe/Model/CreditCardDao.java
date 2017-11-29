package com.cs157a1.payMe.Model;

import java.util.Collection;
import java.util.*;

import com.cs157a1.payMe.Entity.User;
import com.cs157a1.payMe.Entity.creditCard;

public interface CreditCardDao {
	List<creditCard> returnAllInfo();
	
	creditCard returncreditCardBycardNumber(int cardNumber);
	
	void addcreditCardToDB(creditCard creditCard);
	
	void deletecreditCard(int cardNumber);
		
	void updatecreditCard(creditCard creditCard);

}
