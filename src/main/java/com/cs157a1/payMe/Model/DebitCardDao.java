package com.cs157a1.payMe.Model;

import java.util.Collection;
import java.util.*;

import com.cs157a1.payMe.Entity.DebitCard;
import com.cs157a1.payMe.Entity.User;

public interface DebitCardDao {
	List<DebitCard> returnAllInfo();
	
	DebitCard returnDebitCardBycardNumber(long l);
	
	void addDebitCardToDB(DebitCard DebitCard, String username);
	
	void deleteDebitCard(int cardNumber);	
	
	void updateDebitCard(DebitCard DebitCard);
}
