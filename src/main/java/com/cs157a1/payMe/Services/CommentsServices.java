package com.cs157a1.payMe.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.*;

import com.cs157a1.payMe.Entity.Comment;
import com.cs157a1.payMe.Model.CommentsDao;

@Service
public class CommentsServices {
	
	@Autowired
	@Qualifier("CommentsDao")
	private CommentsDao commentDao;
	
	public List<Comment> returnAllInfo(){
		return commentDao.returnAllInfo();
	}
	
	public 	List<Comment> returnAllCommentsFromTransactions(int transId){
		return commentDao.returnAllCommentsFromTransactions(transId);
	}
	
	public Comment returnCommentBycommentId(int commentId, int transId, String username) {
		return commentDao.returnCommentBycommentId(commentId, transId, username);
	}
	
	public void addCommentToDB(Comment Comment) {
		 commentDao.addCommentToDB(Comment);
	}
	
	public void deleteComment(int commentId) {
		 commentDao.deleteComment(commentId);
	}
	
	public void updateComment(Comment Comment) {
		 commentDao.updateComment(Comment);
	}

}
