package com.springboot.bookmyshow.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.bookmyshow.entity.TheatreAdmin;
import com.springboot.bookmyshow.repo.TheatreAdminRepo;

@Repository
public class TheatreAdminDao 
{
	@Autowired
	TheatreAdminRepo theatreAdminRepo;
	
	public TheatreAdmin saveTheatreAdmin(TheatreAdmin theatreAdmin)
	{
		return theatreAdminRepo.save(theatreAdmin);
	}
	
	public  TheatreAdmin findTheatreAdmin(int  theatreAdminId)
	{
		Optional<TheatreAdmin> optional = theatreAdminRepo.findById(theatreAdminId);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;	
	}
	
	public TheatreAdmin deleteTheatreAdmin(int theatreAdminId)
	{
		TheatreAdmin theatreAdminFound = findTheatreAdmin(theatreAdminId);
		if(theatreAdminFound!=null)
		{
			theatreAdminRepo.deleteById(theatreAdminId);
			return theatreAdminFound;
		}
		return null;
	}
	
	public TheatreAdmin updateTheatreAdmin(TheatreAdmin theatreAdmin,int theatreAdminId)
	{
		TheatreAdmin theatreAdminFound = findTheatreAdmin(theatreAdminId);
		if(theatreAdminFound!=null)
		{
			theatreAdminFound.setTheatreAdminId(theatreAdminId);
			theatreAdminFound.setTheatre(theatreAdmin.getTheatre());
			theatreAdminFound.setTheatreAdminEmail(theatreAdmin.getTheatreAdminEmail());
			theatreAdminFound.setTheatreAdminName(theatreAdmin.getTheatreAdminName());
			theatreAdminFound.setTheatreAdminPassword(theatreAdmin.getTheatreAdminPassword());
			return theatreAdminRepo.save(theatreAdminFound);
		}
		return null;
	}
	
	public List<TheatreAdmin> getAllTheatreAdmin()
	{
		return theatreAdminRepo.findAll();
	}

}
