package com.springboot.bookmyshow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.bookmyshow.dao.AdminDao;
import com.springboot.bookmyshow.dao.TheatreDao;
import com.springboot.bookmyshow.entity.Admin;
import com.springboot.bookmyshow.entity.Theatre;
import com.springboot.bookmyshow.util.ResponseStructure;

@Service
public class AdminService 
{
	@Autowired
	AdminDao adminDao;
	
	@Autowired
	TheatreDao theatreDao;
	
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin)
	{
		Admin savedAdmin = adminDao.saveAdmin(admin);
		
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		responseStructure.setMessage("Admin Saved Successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(savedAdmin);
		
		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Admin>> findAdmin(int adminId)
	{
		Admin adminFound = adminDao.findAdmin(adminId);
		
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		responseStructure.setMessage("Admin Found Successfully");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setData(adminFound);
		
		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponseStructure<Admin>> deleteAdmin(int adminId)
	{
		Admin adminDeleted = adminDao.deleteAdmin(adminId);
		
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		responseStructure.setMessage("Admin Deleted Successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(adminDeleted);
		
		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin, int adminId)
	{
		Admin adminUpdated = adminDao.updateAdmin(admin, adminId);
		
		ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
		responseStructure.setMessage("Admin Updated Successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(adminUpdated);
		
		return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Admin>> adminLogin(String adminMail, String adminPassword)
	{
		List<Admin> admin = adminDao.findAllAdmin();
		for(Admin a : admin)
		{
			if(a.getAdminMail().equals(adminMail))
			{
				if(a.getAdminPassword().equals(adminPassword))
				{
					ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
					responseStructure.setMessage("Login Successfull");
					responseStructure.setStatus(HttpStatus.OK.value());
					responseStructure.setData(a);
					
					return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.OK);
				}
				return null; //Password incorrect
			}
			return null; //Email is not Registered
		}
		return null; // No list of admin is found
	}
	
	public ResponseEntity<ResponseStructure<Admin>> addTheatreToAdmin(int adminId, int theatreId, String adminMail, String adminPassword)
	{
		if(adminLogin(adminMail, adminPassword)!=null)
		{
			Admin admin = adminDao.findAdmin(adminId);
			Theatre theatre = theatreDao.findTheatre(theatreId);
			
			List<Theatre> theatreList = admin.getTheatre();
			theatreList.add(theatre);
			admin.setTheatre(theatreList);
			
			Admin updateAdmin = adminDao.updateAdmin(admin, adminId);
			
			if(updateAdmin!=null)
			{
				ResponseStructure<Admin> responseStructure = new ResponseStructure<Admin>();
				responseStructure.setMessage("Theatre addded to Admin Successfully");
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setData(updateAdmin);
				
				return new ResponseEntity<ResponseStructure<Admin>>(responseStructure,HttpStatus.OK);
			}
			return null; // Theatre is not added to admin
		}
		return null; //No admin Found
	}
}
