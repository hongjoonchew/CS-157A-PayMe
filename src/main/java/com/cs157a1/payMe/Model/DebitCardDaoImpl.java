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
import com.cs157a1.payMe.Entity.CreditCard;



@Repository("DebitCardDao")
public class DebitCardDaoImpl implements DebitCardDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<DebitCard> returnAllInfo() {
		final String sql = "select debitCard.number, debitCard.balance, debitCard.type, Cards.name, Cards.CVV, Cards.expiration_year, Cards.expiration_month "
	            + "from debitCard " 
				+ "JOIN Cards on debitCard.number=Cards.number";
		return jdbcTemplate.query(sql, new DebitCardResultSetExtractor());
	}

	@Override
	public DebitCard returnDebitCardBycardNumber(int cardNumber) {
		final String sql = "select debitCard.number, debitCard.balance, debitCard.type, Cards.name, Cards.CVV, Cards.expiration_year, Cards.expiration_month from debitCard"
		           + " JOIN Cards on debitCard.number=Cards.number"
		           + " where debitCard.number = ?";

		return jdbcTemplate.queryForObject(sql, new DebitCardsRowMapper(), cardNumber);	
	}

	@Override
	public void addDebitCardToDB(DebitCard DebitCard) {
		final String sql_debitCard = "INSERT INTO debitCard (number, balance,type) VALUE (?,?,?)";
		final String sql_card = "INSERT INTO Cards (number,name,CVV,expiration_year,expiration_month,card_type) VALUE (?,?,?,?,?,?)";
		
		long number = DebitCard.getCardNumber();
		double balance = DebitCard.getBalance();
		String name = DebitCard.getCardName();
		int cvv = DebitCard.getCvvNumber();
		int exp_year= DebitCard.getExpiration_year();
		int exp_month =DebitCard.getExpiration_month();
		String type = DebitCard.getType();
		String cardType = "debut";
		
		jdbcTemplate.update(sql_debitCard, new Object[] {number,balance,type});
		jdbcTemplate.update(sql_card, new Object[] {number,name,cvv,exp_year,exp_month,cardType});	
	}

	@Override
	public void deleteDebitCard(int cardNumber) {
		final String sql_debitCard = "DELETE FROM debitCard WHERE number = ?";
		final String sql_Card = "DELETE FROM Cards WHERE number = ?";
		
		jdbcTemplate.update(sql_debitCard,cardNumber);
		jdbcTemplate.update(sql_Card,cardNumber);
	}


	@Override
	public void updateDebitCard(DebitCard DebitCard) {
		final String sql_debitCard = "UPDATE debitCard SET balance = ? and type = ? WHERE number = ?";
		final String sql_Card = "UPDATE Card SET name = ? and CVV = ? and expiration_year = ? and expiration_month = ? WHERE number = ?";

		
		long number = DebitCard.getCardNumber();
		double balance = DebitCard.getBalance();
		String name = DebitCard.getCardName();
		int cvv = DebitCard.getCvvNumber();
		int exp_year= DebitCard.getExpiration_year();
		int exp_month =DebitCard.getExpiration_month();
		String type = DebitCard.getType();
		
		jdbcTemplate.update(sql_debitCard, new Object[] {balance,type, number});
		jdbcTemplate.update(sql_Card, new Object[] {name, cvv, number,exp_year,exp_month});
	}
	
	public class DebitCardResultSetExtractor implements ResultSetExtractor<List<DebitCard>> {

		   @Override
		   public List<DebitCard> extractData(ResultSet rs) throws SQLException {
		      List<DebitCard> debitCardList = new ArrayList<DebitCard>();      
		      while(rs.next()){
		    	  DebitCard debitCard = new DebitCard();
			  debitCard.setCardNumber(rs.getLong("number"));
			  debitCard.setCardName(rs.getString("name"));
			  debitCard.setExpiration_year(rs.getInt("expiration_year"));
			  debitCard.setExpiration_month(rs.getInt("expiration_month"));
			  debitCard.setCvvNumber(rs.getInt("CVV"));
			  debitCard.setBalance(rs.getFloat("balance"));
			  debitCard.setType(rs.getString("type"));
		    	  debitCardList.add(debitCard);
		      }
		      return debitCardList;
		  }
		}
	
	private static class DebitCardsRowMapper implements RowMapper<DebitCard>{
		  
		@Override
		public DebitCard mapRow(ResultSet rs, int rowNum) throws SQLException {
			DebitCard debitCard = new DebitCard();
			debitCard.setCardNumber(rs.getLong("number"));
			debitCard.setExpiration_year(rs.getInt("expiration_year"));
			debitCard.setExpiration_month(rs.getInt("expiration_month"));
			debitCard.setCardName(rs.getString("name"));
			debitCard.setCvvNumber(rs.getInt("CVV"));
			debitCard.setBalance(rs.getFloat("balance"));
			debitCard.setType(rs.getString("type"));
			return debitCard;
		}
	}


}
