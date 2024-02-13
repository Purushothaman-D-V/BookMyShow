package com.springboot.bookmyshow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bookmyshow.entity.User;
import com.springboot.bookmyshow.service.UserService;
import com.springboot.bookmyshow.util.ResponseStructure;

@RestController
@RequestMapping("user")
public class UserController
{
	@Autowired
	UserService userService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<User>> saveUser(User user )
	{
		return userService.saveUser(user);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<User>> findUser(int userId)
	{
		return userService.findUser(userId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<User>> deleteUser(int userId)
	{
		return userService.deleteUser(userId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<User>> updateUser(User user, int userId)
	{
		return userService.updateUser(user, userId);
	}

}
