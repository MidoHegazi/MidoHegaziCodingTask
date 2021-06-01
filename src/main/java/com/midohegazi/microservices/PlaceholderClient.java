package com.midohegazi.microservices;

import org.springframework.beans.factory.annotation.Autowired;

import com.midohegazi.microservices.service.CommentService;
import com.midohegazi.microservices.service.UserService;


public class PlaceholderClient {
	
	  public static final String BASE_URL = "https://jsonplaceholder.typicode.com";

	  @Autowired
	  private CommentService commentService;
	  @Autowired
	  private UserService userService;
	

}
