package com.cs157a1.payMe.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cs157a1.payMe.Entity.Comment;
import com.cs157a1.payMe.Entity.Transactions;
import com.cs157a1.payMe.Entity.User;
import com.cs157a1.payMe.Model.UserDaoImpl.UserResultSetExtractor;


@Repository("CommentsDao")
public class CommentsDaoImpl implements CommentsDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Comment> returnAllInfo() {
		 return jdbcTemplate.query("select * from Comments", new CommentResultSetExtractor());
	}
	
	public List<Comment> returnAllCommentsFromTransactions(int transId){
		return jdbcTemplate.query("select * from Comments "
				+ "where Transactions_transid = ? "
				+ "order by commentID", new CommentResultSetExtractor(),transId);
	}

	@Override
	public Comment returnCommentBycommentId(int commentId, int transId, String username) {
		final String sql = "select * from Comments where commentId = ? and Transactions_transId = ? and users_username = ?";
		return jdbcTemplate.queryForObject(sql, new CommentRowMapper(), commentId, transId, username);
	}

	@Override
	public void addCommentToDB(Comment Comment) {
		final String sql = "INSERT INTO Comments(description,Transactions_transId,users_username) VALUES (?,?,?)";
		
		String description = Comment.getDescription();
		Transactions transaction = Comment.getTransactions();
		int transactionId = transaction.getTransID();
		User user = Comment.getUser();
		String username = user.getUsername();
		
		jdbcTemplate.update(sql, new Object[] {description,transactionId,username});			
	}

	@Override
	public void deleteComment(int commentId) {
		final String sql = "DELETE FROM Comments WHERE commentId = ?";
		jdbcTemplate.update(sql,commentId);
	}


	@Override
	public void updateComment(Comment Comment) {
		final String sql = "UPDATE Comments SET description = ? where commentId = ? and Transactions_transId = ? and users_username = ?";

		int id = Comment.getCommentId();
		String description = Comment.getDescription();
		Transactions transaction = Comment.getTransactions();
		int transactionId = transaction.getTransID();
		User user = Comment.getUser();
		String username = user.getUsername();
		
		jdbcTemplate.update(sql, new Object[] {description, id,transactionId,username});	
	}
	
	public class CommentResultSetExtractor implements ResultSetExtractor<List<Comment>> {

		   @Override
		   public List<Comment> extractData(ResultSet rs) throws SQLException {
		      List<Comment> commentlist = new ArrayList<Comment>();      
		      while(rs.next()){
		    	  Comment comment = new Comment();
			  comment.setCommentId(rs.getInt("commentId"));
			  comment.setDescription(rs.getString("description"));
			  User user = new User();
			  user.setUsername(rs.getString("users_username"));
			  comment.setUser(user);
			  commentlist.add(comment);
		      }
		      return commentlist;
		  }
	}
	
	private static class CommentRowMapper implements RowMapper<Comment>{
		  
		@Override
		public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
			Comment comment = new Comment();
			comment.setCommentId(rs.getInt("commentId"));
			comment.setDescription(rs.getString("description"));
			
			return comment;
		}
	}



}
