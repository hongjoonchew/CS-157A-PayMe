package com.cs157a1.payMe.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.*;

import com.cs157a1.payMe.Entity.CreditCard;
import com.cs157a1.payMe.Model.CreditCardDao;

@Service
public class CreditCardsServices {
	
	@Autowired
	@Qualifier("CreditCardDao")
	private CreditCardDao creditCardDao;
	
	List<CreditCard> returnAllInfo(){
		return creditCardDao.returnAllInfo();
	}
	
	CreditCard returncreditCardBycardNumber(int cardNumber) {
		return creditCardDao.returncreditCardBycardNumber(cardNumber);
	}
	
	void addcreditCardToDB(CreditCard creditCard) {
		 creditCardDao.addcreditCardToDB(creditCard);
	}
	
	void deletecreditCard(int cardNumber) {
		 creditCardDao.deletecreditCard(cardNumber);
	}
		
	void updatecreditCard(CreditCard creditCard) {
		 creditCardDao.updatecreditCard(creditCard);
	}

}
