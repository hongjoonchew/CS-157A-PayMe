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
		final String sql = "select * from creditCard"
		           + " JOIN Cards on creditCard.number=Cards.number";
		return jdbcTemplate.query(sql, new CreditCardResultSetExtractor());
	}

	@Override
	public CreditCard returncreditCardBycardNumber(long cardNumber) {
		String sql = "select creditCard.number, creditCard.creditLimit, creditCard.issuer, Cards.name, Cards.CVV, Cards.expiration_year, Cards.expiration_month from creditCard"
		           + " JOIN Cards on creditCard.number=Cards.number"
		           + " where creditCard.number = ?";

       return jdbcTemplate.queryForObject(sql, new CreditCardsRowMapper(), cardNumber);	
	}

	@Override
	public void addcreditCardToDB(CreditCard creditCard, String username) {
		final String sql_creditCard = "INSERT INTO creditCard (number, creditLimit, issuer) VALUE (?,?,?)";
		final String sql_card = "INSERT INTO Cards (number,name,CVV,expiration_year,expiration_month,card_type,username,card_type) VALUE (?,?,?,?,?,?,?,?)";
		
		long number = creditCard.getCardNumber();
		String name = creditCard.getCardName();
		int cvv = creditCard.getCvvNumber();
		float creditLimit = creditCard.getCreditLimit();
		int exp_year= 8;
		int exp_month =7;
		//int exp_year= creditCard.getExpiration_year();
		//int exp_month =creditCard.getExpiration_month();
		String issuer = creditCard.getIssuer();
		String cardType = "credit";
		String type = creditCard.getCardType();


		
		jdbcTemplate.update(sql_creditCard, new Object[] {number,creditLimit,issuer});
		jdbcTemplate.update(sql_card, new Object[] {number,name,cvv,exp_year,exp_month,cardType,username,type});		
	}

	@Override
	public void deletecreditCard(long cardNumber) {
		final String sql_creditCard = "DELETE FROM creditCard WHERE number = ?";
		final String sql_Card = "DELETE FROM Cards WHERE number = ?";
		
		jdbcTemplate.update(sql_creditCard,cardNumber);
		jdbcTemplate.update(sql_Card,cardNumber);
	}

	@Override
	public void updatecreditCard(CreditCard creditCard) {
		final String sql_creditCard = "UPDATE creditCard SET creditLimit = ? and issuer = ? WHERE number = ?";
		final String sql_Card = "UPDATE Card SET name = ? and CVV = ? WHERE number = ?";

		
		long number = creditCard.getCardNumber();
		String name = creditCard.getCardName();
		int cvv = creditCard.getCvvNumber();
		float creditLimit = creditCard.getCreditLimit();
		int exp_year= creditCard.getExpiration_year();
		int exp_month =creditCard.getExpiration_month();
		String issuer = creditCard.getIssuer();


		
		jdbcTemplate.update(sql_creditCard, new Object[] {creditLimit, issuer, number});
		jdbcTemplate.update(sql_Card, new Object[] {name, cvv, number,exp_year,exp_month});	
	}
	
	public class CreditCardResultSetExtractor implements ResultSetExtractor<List<CreditCard>> {

		   @Override
		   public List<CreditCard> extractData(ResultSet rs) throws SQLException {
		      List<CreditCard> creditCardlist = new ArrayList<CreditCard>();      
		      while(rs.next()){
			        CreditCard creditCard = new CreditCard();
					creditCard.setCardNumber(rs.getLong("number"));
					creditCard.setCardName(rs.getString("name"));
					creditCard.setCvvNumber(rs.getInt("CVV"));
					creditCard.setExpiration_year(rs.getInt("expiration_year"));
					creditCard.setExpiration_month(rs.getInt("expiration_month"));
					creditCard.setCreditLimit(rs.getFloat("creditLimit"));
					creditCard.setIssuer(rs.getString("issuer"));
					creditCard.setCardType(rs.getString("card_type"));
			        creditCardlist.add(creditCard);
		      }
		      return creditCardlist;
		  }
		}
	
	private static class CreditCardsRowMapper implements RowMapper<CreditCard>{
		  
		@Override
		public CreditCard mapRow(ResultSet rs, int rowNum) throws SQLException {
			CreditCard creditCard = new CreditCard();
			creditCard.setCardNumber(rs.getLong("number"));
			creditCard.setCardName(rs.getString("name"));
			creditCard.setExpiration_year(rs.getInt("expiration_year"));
			creditCard.setExpiration_month(rs.getInt("expiration_month"));
			creditCard.setCvvNumber(rs.getInt("CVV"));
			creditCard.setCreditLimit(rs.getFloat("creditLimit"));
			creditCard.setIssuer(rs.getString("issuer"));
			creditCard.setCardType(rs.getString("card_type"));
			return creditCard;
		}
	}


}
