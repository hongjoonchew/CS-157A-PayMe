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
	@Qualifier("mysql")
	private CommentsDao commentDao;
	
	List<Comment> returnAllInfo(){
		return commentDao.returnAllInfo();
	}
	
	Comment returnCommentBycommentId(int commentId, int transId, String username) {
		return commentDao.returnCommentBycommentId(commentId, transId, username);
	}
	
	void addCommentToDB(Comment Comment) {
		 commentDao.addCommentToDB(Comment);
	}
	
	void deleteComment(int commentId) {
		 commentDao.deleteComment(commentId);
	}
	
	void updateComment(Comment Comment) {
		 commentDao.updateComment(Comment);
	}

}
