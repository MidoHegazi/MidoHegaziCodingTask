package com.midohegazi.microservices.service;

import com.midohegazi.microservices.repo.UserRepository;
import com.midohegazi.microservices.resource.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



import java.io.File;
import java.util.List;

@Service
public class UserService {
@Autowired
  private UserRepository userRepository;



  public List<User> getUsers() {
  return userRepository.getUsers();
  }
  

  public User saveUser( User user) {
    return userRepository.saveUser(user);
  }
  
  
  public User getUser(int id) {
	   
	 return  userRepository.findUserById(id);
  }
  
  
  public void updateUser (int id,User user) {
	  
	  userRepository.updateUser(id, user);;
  }
  
 public void deleteUser(int id ) {
	  
	  userRepository.deleteUser(id);
  }

  
  

}
