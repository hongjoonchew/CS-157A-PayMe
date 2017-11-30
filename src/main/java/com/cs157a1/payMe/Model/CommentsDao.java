package com.cs157a1.payMe.Model;

import java.util.Collection;
import java.util.*;

import com.cs157a1.payMe.Entity.Comment;
import com.cs157a1.payMe.Entity.Transactions;
import com.cs157a1.payMe.Entity.User;

public interface CommentsDao {
	List<Comment> returnAllInfo();
	
	Comment returnCommentBycommentId(int commentId, int transId, String username);
	
	void addCommentToDB(Comment Comment);
	
	void deleteComment(int commentId);
	
	void updateComment(Comment Comment);

}
