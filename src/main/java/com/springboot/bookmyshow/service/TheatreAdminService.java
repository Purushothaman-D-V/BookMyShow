package com.springboot.bookmyshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.bookmyshow.dao.TheatreAdminDao;
import com.springboot.bookmyshow.entity.TheatreAdmin;
import com.springboot.bookmyshow.util.ResponseStructure;

@Service
public class TheatreAdminService 
{
	@Autowired
	TheatreAdminDao theatreAdminDao;
	
	public ResponseEntity<ResponseStructure<TheatreAdmin>> saveTheatreAdmin(TheatreAdmin theatreAdmin)
	{
		TheatreAdmin theatreAdminSaved = theatreAdminDao.saveTheatreAdmin(theatreAdmin);
		
		ResponseStructure<TheatreAdmin> responseStructure = new ResponseStructure<TheatreAdmin>();
		responseStructure.setMessage("TheatreAdmin Saved Successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(theatreAdminSaved);
		
		return new ResponseEntity<ResponseStructure<TheatreAdmin>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<TheatreAdmin>> findTheatreAdmin(int theatreAdminId)
	{
		TheatreAdmin theatreAdminFound = theatreAdminDao.findTheatreAdmin(theatreAdminId);
		
		ResponseStructure<TheatreAdmin> responseStructure = new ResponseStructure<TheatreAdmin>();
		responseStructure.setMessage("TheatreAdmin Found Successfully");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setData(theatreAdminFound);
		
		return new ResponseEntity<ResponseStructure<TheatreAdmin>>(responseStructure,HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponseStructure<TheatreAdmin>> deleteTheatreAdmin(int theatreAdminId)
	{
		TheatreAdmin theatreAdminDeleted = theatreAdminDao.deleteTheatreAdmin(theatreAdminId);
		
		ResponseStructure<TheatreAdmin> responseStructure = new ResponseStructure<TheatreAdmin>();
		responseStructure.setMessage("TheatreAdmin Deleted Successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(theatreAdminDeleted);
		
		return new ResponseEntity<ResponseStructure<TheatreAdmin>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<TheatreAdmin>> updateTheatreAdmin(TheatreAdmin theatreAdmin, int theatreAdminId)
	{
		TheatreAdmin updatedTheatreAdmin = theatreAdminDao.updateTheatreAdmin(theatreAdmin, theatreAdminId);
		
		ResponseStructure<TheatreAdmin> responseStructure = new ResponseStructure<TheatreAdmin>();
		responseStructure.setMessage("TheatreAdmin Updated Successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(updatedTheatreAdmin);
		
		return new ResponseEntity<ResponseStructure<TheatreAdmin>>(responseStructure,HttpStatus.OK);
	}

}
