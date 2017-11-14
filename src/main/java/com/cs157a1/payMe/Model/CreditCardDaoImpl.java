package com.cs157a1.payMe.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cs157a1.payMe.Entity.User;
import com.cs157a1.payMe.Entity.creditCard;


@Repository("CreditCardDao")
public class CreditCardDaoImpl implements CreditCardDao {

	@Override
	public Collection<creditCard> returnAllInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public creditCard returncreditCardBycardNumber(int cardNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addcreditCardToDB(creditCard creditCard) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletecreditCard(int cardNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String returnCardNumber(int cardNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String returnCardName(int cardNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int returnCardCvvNumber(int cardNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float returnCreditLimit(int cardNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updatecreditCard(creditCard creditCard) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User returnUserOfCreditCard(int cardNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
