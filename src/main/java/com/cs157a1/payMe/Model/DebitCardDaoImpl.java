package com.cs157a1.payMe.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cs157a1.payMe.Entity.DebitCard;
import com.cs157a1.payMe.Entity.User;


@Repository("DebitCardDao")
public class DebitCardDaoImpl implements DebitCardDao {

	@Override
	public Collection<DebitCard> returnAllInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DebitCard returnDebitCardBycardNumber(int cardNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDebitCardToDB(DebitCard DebitCard) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDebitCard(int cardNumber) {
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
	public float returnBalance(int cardNumber) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateDebitCard(DebitCard DebitCard) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User returnUserOfDebitCard(int cardNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
