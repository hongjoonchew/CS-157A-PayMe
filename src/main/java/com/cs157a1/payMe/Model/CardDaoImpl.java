package com.cs157a1.payMe.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cs157a1.payMe.Entity.Card;
import com.cs157a1.payMe.Entity.User;


@Repository("CardDao")
public class CardDaoImpl implements CardDao {

	@Override
	public Collection<Card> returnAllInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Card returnCardByUsername(int cardNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCardToDB(Card Card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCard(int cardNumber) {
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
	public void updateCard(Card Card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User returnUserOfcard(int cardNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
