package com.midohegazi.microservices.service;
import com.midohegazi.microservices.repo.CommentRepository;
import com.midohegazi.microservices.resource.Comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CommentService {
	@Autowired
	  private CommentRepository commentRepository;



	  public List<Comment> getComments() {
	  return commentRepository.getComments();
	  }
	  

	  public Comment saveComment( Comment comment) {
	    return commentRepository.saveComment(comment);
	  }
	  
	  
	  public Comment getComment(int id) {
		   
		 return  commentRepository.findCommentById(id);
	  }
	  
	  
	  public void updateComment (int id,Comment comment) {
		  
		  commentRepository.updateComment(id, comment);
	  }
	  
	 public void deleteComment(int id ) {
		  
		  commentRepository.deleteComment(id);
	  }

}
