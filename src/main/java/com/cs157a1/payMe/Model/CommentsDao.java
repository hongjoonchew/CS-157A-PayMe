package com.cs157a1.payMe.Model;

import java.util.Collection;

import com.cs157a1.payMe.Entity.Comment;
import com.cs157a1.payMe.Entity.Transactions;
import com.cs157a1.payMe.Entity.User;

public interface CommentsDao {
	Collection<Comment> returnAllInfo();
	
	Comment returnCommentBycommentId(int commentId);
	
	void addCommentToDB(Comment Comment);
	
	void deleteComment(int commentId);
	
	String returnDescription(int commentId);

	void updateComment(Comment Comment);

	User returnWriterOfComment(int commentId);
	
	Transactions returnTransactions(int commentId);

}
