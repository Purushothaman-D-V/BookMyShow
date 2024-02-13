package com.springboot.bookmyshow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.bookmyshow.entity.Theatre;
import com.springboot.bookmyshow.repo.TheatreRepo;

@Repository
public class TheatreDao 
{
	@Autowired
	TheatreRepo theatreRepo;
	
	public Theatre saveTheatre(Theatre theatre)
	{
		return theatreRepo.save(theatre);
	}
	
	public  Theatre findTheatre(int  theatreId)
	{
		Optional<Theatre> optional = theatreRepo.findById(theatreId);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;	
	}
	
	public Theatre deleteTheatre(int theatreId)
	{
		Theatre theatreFound = findTheatre(theatreId);
		if(theatreFound!=null)
		{
			theatreRepo.deleteById(theatreId);
			return theatreFound;
		}
		return null;
	}
	
	public Theatre updateTheatre(Theatre theatre,int theatreId)
	{
		Theatre theatreFound = findTheatre(theatreId);
		if(theatreFound!=null)
		{
			theatreFound.setTheatreId(theatreId);
			theatreFound.setTheatreAdmin(theatre.getTheatreAdmin());
			theatreFound.setTheatreLocation(theatre.getTheatreLocation());
			theatreFound.setTheatreName(theatre.getTheatreName());
			theatreFound.setScreen(theatre.getScreen());
			return theatreRepo.save(theatreFound);
		}
		return null;
	}
}
