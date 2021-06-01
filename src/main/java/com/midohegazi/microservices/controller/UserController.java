package com.midohegazi.microservices.controller;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.midohegazi.microservices.resource.User;
import com.midohegazi.microservices.service.UserService;

@RestController
public class UserController {
ObjectMapper mapper= new ObjectMapper();
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/users")
	public List<User> getUsers(){
		
		return userService.getUsers();
		
		
	}
	
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable int id) {
		 return userService.getUser(id);
		
	}
	
	@PutMapping("/users/{id}")
	public void updateUser(@PathVariable int id,@RequestBody User user) {
		  userService.updateUser(id, user);
		
	}
	
	
	@PostMapping("/users")
	public User saveUser(@RequestBody User user) {
		 return userService.saveUser(user);
		 
		
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		  userService.deleteUser(id);
		
	}
	

	@PostMapping("/jsons/write-users-data")
	public void saveUser(@RequestBody String data) {
		
		try {
			mapper.writeValue( new File("/resources/users.json"),data);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		 
		
	}
	
	

}
