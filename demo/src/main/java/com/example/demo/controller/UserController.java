package com.example.demo.controller;

import java.util.List;
import java.util.UUID;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

	private final UserService userService;


	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping
	public void addUser(@RequestBody User user){
		userService.addUser(user);
	}

	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping(path = "{id}")
	public User getUser(@PathVariable("id") UUID id){
		return userService.getUser(id)
				.orElse(null);
	}

	@DeleteMapping(path = "{id}")
	public void deleteUserById(@PathVariable("id") UUID id){
		userService.deleteUserById(id);
	}
	
	@PutMapping(path = "{id}")
	public void updateUserById(@PathVariable("id") UUID id, @RequestBody User user){
		userService.updateUserById(id, user);
	}
}
