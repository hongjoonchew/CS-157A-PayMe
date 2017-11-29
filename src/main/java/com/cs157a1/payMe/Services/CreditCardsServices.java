package com.cs157a1.payMe.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.*;

import com.cs157a1.payMe.Entity.creditCard;
import com.cs157a1.payMe.Model.CreditCardDao;

@Service
public class CreditCardsServices {
	
	@Autowired
	@Qualifier("mysql")
	private CreditCardDao creditCardDao;
	
	List<creditCard> returnAllInfo(){
		return creditCardDao.returnAllInfo();
	}
	
	creditCard returncreditCardBycardNumber(int cardNumber) {
		return creditCardDao.returncreditCardBycardNumber(cardNumber);
	}
	
	void addcreditCardToDB(creditCard creditCard) {
		 creditCardDao.addcreditCardToDB(creditCard);
	}
	
	void deletecreditCard(int cardNumber) {
		 creditCardDao.deletecreditCard(cardNumber);
	}
		
	void updatecreditCard(creditCard creditCard) {
		 creditCardDao.updatecreditCard(creditCard);
	}

}
