package com.cs157a1.payMe.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.*;

import com.cs157a1.payMe.Entity.DebitCard;
import com.cs157a1.payMe.Model.DebitCardDao;

@Service
public class DebitCardsServices {
	
	@Autowired
	@Qualifier("DebitCardDao")
	private DebitCardDao debitCardDao;
	
	List<DebitCard> returnAllInfo(){
		return debitCardDao.returnAllInfo();
	}
	
	DebitCard returnDebitCardBycardNumber(int cardNumber) {
		return debitCardDao.returnDebitCardBycardNumber(cardNumber);
	}
	
	void addDebitCardToDB(DebitCard DebitCard) {
		 debitCardDao.addDebitCardToDB(DebitCard);
	}
	
	void deleteDebitCard(int cardNumber) {
		 debitCardDao.deleteDebitCard(cardNumber);
	}
	
	void updateDebitCard(DebitCard DebitCard) {
		 debitCardDao.updateDebitCard(DebitCard);
	}

}
