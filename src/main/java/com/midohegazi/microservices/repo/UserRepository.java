package com.midohegazi.microservices.repo;

import com.midohegazi.microservices.resource.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import static com.midohegazi.microservices.PlaceholderClient.BASE_URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



@Component
public class UserRepository {
 
  private static final String RESOURCE_ENDPOINT = "/users";
  @Autowired
  private RestTemplate restTemplate;

  public List<User> getUsers() {
    final ResponseEntity<User[]> responseEntity = restTemplate.getForEntity(BASE_URL + RESOURCE_ENDPOINT, User[].class);
    final User[] users = responseEntity.getBody();
    return users == null ? Collections.emptyList() : Arrays.asList(users);
  }

  public User findUserById(final int id) {
    final ResponseEntity<User> responseEntity = restTemplate.getForEntity(BASE_URL +RESOURCE_ENDPOINT+ "/"+id, User.class, id);
    return responseEntity.getBody();
  }

  public User saveUser(final User user) {
    final ResponseEntity<User> responseEntity = restTemplate.postForEntity(BASE_URL + RESOURCE_ENDPOINT, user, User.class);
    return responseEntity.getBody();
  }
  
  public void updateUser(int id,User user) {
	  
	  restTemplate.put(BASE_URL + RESOURCE_ENDPOINT +"/"+id,user);
	    
  }
  
  public void deleteUser(int id ) {
	  
	  restTemplate.delete(BASE_URL+RESOURCE_ENDPOINT+"/"+id );
  }


  
  
  
}
