package com.midohegazi.microservices.repo;

import com.midohegazi.microservices.resource.Comment;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.midohegazi.microservices.PlaceholderClient.BASE_URL;

@Component
public class CommentRepository {

  private static final String RESOURCE_ENDPOINT = "/comments";
  @Autowired
  private RestTemplate restTemplate;

  public List<Comment> getComments() {
    final ResponseEntity<Comment[]> responseEntity = restTemplate.getForEntity(BASE_URL + RESOURCE_ENDPOINT, Comment[].class);
    final Comment[] comments = responseEntity.getBody();
    return comments == null ? Collections.emptyList() : Arrays.asList(comments);
  }

  public Comment findCommentById(final int id) {
    final ResponseEntity<Comment> responseEntity = restTemplate.getForEntity(BASE_URL + RESOURCE_ENDPOINT+"/"+id, Comment.class, id);
    return responseEntity.getBody();
  }

  public Comment saveComment(final Comment comment) {
    final ResponseEntity<Comment> responseEntity = restTemplate.postForEntity(BASE_URL + RESOURCE_ENDPOINT, comment, Comment.class);
    return responseEntity.getBody();
  }
  
  
 public void updateComment(int id,Comment comment) {
	  
	  restTemplate.put(BASE_URL + RESOURCE_ENDPOINT +"/"+id,comment);
	    
  }
  
  public void deleteComment(int id ) {
	  
	  restTemplate.delete(BASE_URL+RESOURCE_ENDPOINT+"/"+id );
  }

}
