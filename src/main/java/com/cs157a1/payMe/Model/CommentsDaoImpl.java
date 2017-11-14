package com.cs157a1.payMe.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cs157a1.payMe.Entity.Comment;
import com.cs157a1.payMe.Entity.Transactions;
import com.cs157a1.payMe.Entity.User;


@Repository("CommentsDao")
public class CommentsDaoImpl implements CommentsDao {

	@Override
	public Collection<Comment> returnAllInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment returnCommentBycommentId(int commentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCommentToDB(Comment Comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteComment(int commentId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String returnDescription(int commentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateComment(Comment Comment) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User returnWriterOfComment(int commentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transactions returnTransactions(int commentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
