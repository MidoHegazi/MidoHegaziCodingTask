package com.midohegazi.microservices.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.midohegazi.microservices.resource.Comment;
import com.midohegazi.microservices.service.CommentService;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CommentController {
ObjectMapper mapper= new ObjectMapper();
	
	@Autowired
	private CommentService commentService;
	
	
	@GetMapping("/comments")
	public List<Comment> getComment(){
		
		return commentService.getComments();
		
		
	}
	
	@GetMapping("/comments/{id}")
	public Comment getCommentById(@PathVariable int id) {
		 return commentService.getComment(id);
		
	}
	
	@PutMapping("/comments/{id}")
	public void updateUser(@PathVariable int id,@RequestBody Comment comment) {
		  commentService.updateComment(id, comment);
		
	}
	
	@PostMapping("/comments")
	public Comment saveComment(@RequestBody Comment comment) {
		 return commentService.saveComment(comment);
		 
		
	}
	
	@DeleteMapping("/comments/{id}")
	public void deleteUser(@PathVariable int id) {
		  commentService.deleteComment(id);
		
	}
	

	@PostMapping("/jsons/write-comments-data")
	public void saveData(@RequestBody String data) {
		
		try {
			mapper.writeValue( new File("/resources/comments.json"),data);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		 
	}

}
