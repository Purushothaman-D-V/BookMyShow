package com.springboot.bookmyshow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.bookmyshow.entity.User;
import com.springboot.bookmyshow.repo.UserRepo;

@Repository
public class UserDao 
{

	@Autowired
	UserRepo userRepo;
	
	public User saveUser(User user)
	{
		return userRepo.save(user);
	}
	
	public User findUser(int  userId)
	{
		Optional<User> optional = userRepo.findById(userId);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;	
	}
	
	public User deleteUser(int userId)
	{
		User userFound = findUser(userId);
		if(userFound!=null)
		{
			userRepo.deleteById(userId);
			return userFound;
		}
		return null;
	}
	
	public User updateUser(User user, int userId)
	{
		User userFound = findUser(userId);
		if(userFound!=null)
		{
			userFound.setUserId(userId);
			userFound.setUserName(user.getUserName());
			userFound.setUserEmail(user.getUserEmail());
			userFound.setUserPassword(user.getUserPassword());
			userFound.setBooking(user.getBooking());
			return userRepo.save(userFound);
		}
		return null;
	}
}
