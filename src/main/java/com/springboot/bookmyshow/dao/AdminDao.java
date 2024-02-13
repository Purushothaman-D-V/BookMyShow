package com.springboot.bookmyshow.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.bookmyshow.entity.Admin;
import com.springboot.bookmyshow.repo.AdminRepo;

@Repository
public class AdminDao 
{
	@Autowired
	AdminRepo adminRepo;

	public Admin saveAdmin(Admin admin)
	{
		return adminRepo.save(admin);
	}
	
	public Admin findAdmin(int adminId)
	{
		Optional<Admin> optional = adminRepo.findById(adminId);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}
	
	public Admin deleteAdmin(int adminId)
	{
		Admin adminFound = findAdmin(adminId);
		if(adminFound!=null)
		{
			adminRepo.deleteById(adminId);
			return adminFound;
		}
		return null;
	}
	
	public Admin updateAdmin(Admin admin,int adminId)
	{
		Admin adminFound = findAdmin(adminId);
		if(adminFound!=null)
		{
			adminFound.setAdminId(adminId);
			adminFound.setAdminMail(admin.getAdminMail());
			adminFound.setAdminName(admin.getAdminName());
			adminFound.setAdminPassword(admin.getAdminPassword());
			adminFound.setTheatre(admin.getTheatre());
			adminRepo.save(adminFound);
		}
		return null;
	}
	
	public List<Admin> findAllAdmin()
	{
		return adminRepo.findAll();
	}
}
