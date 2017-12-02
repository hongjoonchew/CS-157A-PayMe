package com.cs157a1.payMe.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import com.cs157a1.payMe.Entity.CreditCard;


@Repository("CreditCardDao")
public class CreditCardDaoImpl implements CreditCardDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<CreditCard> returnAllInfo() {
		final String sql = "select creditCard.number, creditCard.creditLimit, Cards.name, Cards.CVV from creditCard"
		           + " JOIN Cards on creditCard.number=Cards.number";
		return jdbcTemplate.query(sql, new CreditCardResultSetExtractor());
	}

	@Override
	public CreditCard returncreditCardBycardNumber(int cardNumber) {
		String sql = "select creditCard.number, creditCard.creditLimit, Cards.name, Cards.CVV from creditCard"
		           + " JOIN Cards on creditCard.number=Cards.number"
		           + " where creditCard.number = ?";

       return jdbcTemplate.queryForObject(sql, new CreditCardsRowMapper(), cardNumber);	
	}

	@Override
	public void addcreditCardToDB(CreditCard creditCard) {
		final String sql_creditCard = "INSERT INTO creditCard (number, creditLimit) VALUE (?,?)";
		final String sql_card = "INSERT INTO Cards (number,name,CVV) VALUE (?,?)";
		
		int number = creditCard.getCardNumber();
		String name = creditCard.getCardName();
		int cvv = creditCard.getCvvNumber();
		float creditLimit = creditCard.getCreditLimit();

		
		jdbcTemplate.update(sql_creditCard, new Object[] {number,creditLimit});
		jdbcTemplate.update(sql_card, new Object[] {number,name,cvv});		
	}

	@Override
	public void deletecreditCard(int cardNumber) {
		final String sql_creditCard = "DELETE FROM creditCard WHERE number = ?";
		final String sql_Card = "DELETE FROM Cards WHERE number = ?";
		
		jdbcTemplate.update(sql_creditCard,cardNumber);
		jdbcTemplate.update(sql_Card,cardNumber);
	}

	@Override
	public void updatecreditCard(CreditCard creditCard) {
		final String sql_creditCard = "UPDATE creditCard SET creditLimit = ? WHERE number = ?";
		final String sql_Card = "UPDATE Card SET name = ? and CVV = ? WHERE number = ?";

		
		int number = creditCard.getCardNumber();
		String name = creditCard.getCardName();
		int cvv = creditCard.getCvvNumber();
		float creditLimit = creditCard.getCreditLimit();

		
		jdbcTemplate.update(sql_creditCard, new Object[] {creditLimit, number});
		jdbcTemplate.update(sql_Card, new Object[] {name, cvv, number});	
	}
	
	public class CreditCardResultSetExtractor implements ResultSetExtractor<List<CreditCard>> {

		   @Override
		   public List<CreditCard> extractData(ResultSet rs) throws SQLException {
		      List<CreditCard> creditCardlist = new ArrayList<CreditCard>();      
		      while(rs.next()){
			        CreditCard creditCard = new CreditCard();
					creditCard.setCardNumber(rs.getInt("number"));
					creditCard.setCardName(rs.getString("name"));
					creditCard.setCvvNumber(rs.getInt("CVV"));
					creditCard.setCreditLimit(rs.getFloat("creditLimit"));
			        creditCardlist.add(creditCard);
		      }
		      return creditCardlist;
		  }
		}
	
	private static class CreditCardsRowMapper implements RowMapper<CreditCard>{
		  
		@Override
		public CreditCard mapRow(ResultSet rs, int rowNum) throws SQLException {
			CreditCard creditCard = new CreditCard();
			creditCard.setCardNumber(rs.getInt("number"));
			creditCard.setCardName(rs.getString("name"));
			creditCard.setCvvNumber(rs.getInt("CVV"));
			creditCard.setCreditLimit(rs.getFloat("creditLimit"));
			return creditCard;
		}
	}


}
