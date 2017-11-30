package com.cs157a1.payMe.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cs157a1.payMe.Entity.DebitCard;
import com.cs157a1.payMe.Entity.creditCard;



@Repository("DebitCardDao")
public class DebitCardDaoImpl implements DebitCardDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<DebitCard> returnAllInfo() {
		final String sql = "select debtCard.number, debtCard.balance, Cards.name, Cards.CVV from debtCard"
		           + "JOIN Cards on debtCard.number=Cards.number";
		return jdbcTemplate.query(sql, new DebitCardResultSetExtractor());
	}

	@Override
	public DebitCard returnDebitCardBycardNumber(int cardNumber) {
		final String sql = "select debtCard.number, debtCard.balance, Cards.name, Cards.CVV from debtCard"
				           + "JOIN Cards on debtCard.number=Cards.number"
				           + "where debtCard.number = ?";

		return jdbcTemplate.queryForObject(sql, new DeibtCardsRowMapper(), cardNumber);	
	}

	@Override
	public void addDebitCardToDB(DebitCard DebitCard) {
		final String sql_debitCard = "INSERT INTO debtCard (number, balance) VALUE (?,?)";
		final String sql_card = "INSERT INTO Cards (number,name,CVV) VALUE (?,?)";
		
		int number = DebitCard.getCardNumber();
		double balance = DebitCard.getBalance();
		String name = DebitCard.getCardName();
		int cvv = DebitCard.getCvvNumber();
		
		jdbcTemplate.update(sql_debitCard, new Object[] {number,balance});
		jdbcTemplate.update(sql_card, new Object[] {number,name,cvv});	
	}

	@Override
	public void deleteDebitCard(int cardNumber) {
		final String sql_debitCard = "DELETE FROM debtCARD WHERE number = ?";
		final String sql_Card = "DELETE FROM Cards WHERE number = ?";
		
		jdbcTemplate.update(sql_debitCard,cardNumber);
		jdbcTemplate.update(sql_Card,cardNumber);
	}


	@Override
	public void updateDebitCard(DebitCard DebitCard) {
		final String sql_debtCard = "UPDATE debtCard SET balance = ? WHERE number = ?";
		final String sql_Card = "UPDATE Card SET name = ? and CVV = ? WHERE number = ?";

		
		int number = DebitCard.getCardNumber();
		double balance = DebitCard.getBalance();
		String name = DebitCard.getCardName();
		int cvv = DebitCard.getCvvNumber();
		
		jdbcTemplate.update(sql_debtCard, new Object[] {balance, number});
		jdbcTemplate.update(sql_Card, new Object[] {name, cvv, number});
	}
	
	public class DebitCardResultSetExtractor implements ResultSetExtractor<List<DebitCard>> {

		   @Override
		   public List<DebitCard> extractData(ResultSet rs) throws SQLException {
		      List<DebitCard> debitCardList = new ArrayList<DebitCard>();      
		      while(rs.next()){
		    	  DebitCard debitCard = new DebitCard();
			  debitCard.setCardNumber(rs.getInt("number"));
			  debitCard.setCardName(rs.getString("name"));
			  debitCard.setCvvNumber(rs.getInt("CVV"));
			  debitCard.setBalance(rs.getFloat("balance"));
		    	  debitCardList.add(debitCard);
		      }
		      return debitCardList;
		  }
		}
	
	private static class DeibtCardsRowMapper implements RowMapper<DebitCard>{
		  
		@Override
		public DebitCard mapRow(ResultSet rs, int rowNum) throws SQLException {
			DebitCard debitCard = new DebitCard();
			debitCard.setCardNumber(rs.getInt("number"));
			debitCard.setCardName(rs.getString("name"));
			debitCard.setCvvNumber(rs.getInt("CVV"));
			debitCard.setBalance(rs.getFloat("balance"));
			return debitCard;
		}
	}


}
