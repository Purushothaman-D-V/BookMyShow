package com.springboot.bookmyshow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.bookmyshow.dao.UserDao;
import com.springboot.bookmyshow.entity.User;
import com.springboot.bookmyshow.util.ResponseStructure;

@Service
public class UserService 
{
	@Autowired
	UserDao userDao;
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User user)
	{
		User userSaved = userDao.saveUser(user);
		
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		responseStructure.setMessage("User Saved Successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(userSaved);
		
		return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<User>> findUser(int userId)
	{
		User userFound = userDao.findUser(userId);
		
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		responseStructure.setMessage("User Found Successfully");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setData(userFound);
		
		return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponseStructure<User>> deleteUser(int userId)
	{
		User userDeleted = userDao.deleteUser(userId);
		
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		responseStructure.setMessage("User Deleted Successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(userDeleted);
		
		return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<User>> updateUser(User user, int userId)
	{
		User updatedUser = userDao.updateUser(user, userId);
		
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		responseStructure.setMessage("User Updated Successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(updatedUser);
		
		return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<User>> userLogin(String userMail, String userPassword)
	{
		List<User> user = userDao.getAllUser();
		for(User u: user)
		{
			if(u.getUserEmail().equals(userMail))
			{
				if(u.getUserPassword().equals(userPassword))
				{
					ResponseStructure<User> responseStructure = new ResponseStructure<User>();
					responseStructure.setMessage("User Login Successfull");
					responseStructure.setStatus(HttpStatus.OK.value());
					responseStructure.setData(u);
					
					return new ResponseEntity<ResponseStructure<User>>(responseStructure,HttpStatus.OK);
				}
				return null;
			}
			return null;
		}
		return null;
	}
}
