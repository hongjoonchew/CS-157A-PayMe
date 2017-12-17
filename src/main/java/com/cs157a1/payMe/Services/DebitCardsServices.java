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
	
	public List<DebitCard> returnAllInfo(){
		return debitCardDao.returnAllInfo();
	}
	
	public DebitCard returnDebitCardBycardNumber(long l) {
		return debitCardDao.returnDebitCardBycardNumber(l);
	}
	
	public void addDebitCardToDB(DebitCard DebitCard, String username) {
		 debitCardDao.addDebitCardToDB(DebitCard,username);
	}
	
	public void deleteDebitCard(long cardNumber) {
		 debitCardDao.deleteDebitCard(cardNumber);
	}
	
	public void updateDebitCard(DebitCard DebitCard) {
		 debitCardDao.updateDebitCard(DebitCard);
	}

}
