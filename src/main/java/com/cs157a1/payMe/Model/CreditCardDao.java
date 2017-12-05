package com.cs157a1.payMe.Model;

import java.util.Collection;
import java.util.*;

import com.cs157a1.payMe.Entity.User;
import com.cs157a1.payMe.Entity.CreditCard;

public interface CreditCardDao {
	List<CreditCard> returnAllInfo();
	
	CreditCard returncreditCardBycardNumber(long l);
	
	void addcreditCardToDB(CreditCard creditCard, String username);
	
	void deletecreditCard(int cardNumber);
		
	void updatecreditCard(CreditCard creditCard);

}
