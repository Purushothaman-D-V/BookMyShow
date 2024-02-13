package com.springboot.bookmyshow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.bookmyshow.entity.Screen;
import com.springboot.bookmyshow.repo.ScreenRepo;

@Repository
public class ScreenDao 
{
	@Autowired
	ScreenRepo screenRepo;

	public Screen saveScreen(Screen screen)
	{
		return screenRepo.save(screen);
	}
	
	public  Screen findScreen(int  screenId)
	{
		Optional< Screen> optional = screenRepo.findById(screenId);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;	
	}
	
	public Screen deleteScreen(int screenId)
	{
		Screen screenFound = findScreen(screenId);
		if(screenFound!=null)
		{
			screenRepo.deleteById(screenId);
			return screenFound;
		}
		return null;
	}
	
	public Screen updateScreen(Screen screen, int screenId)
	{
		Screen screenFound = findScreen(screenId);
		if(screenFound!=null)
		{
			screenFound.setScreenId(screenId);
			screenFound.setMovie(screen.getMovie());
			screenFound.setScreenDate(screen.getScreenDate());
			screenFound.setScreenTime(screen.getScreenTime());
			screenFound.setStatus(screen.getStatus());
			return screenRepo.save(screenFound);
		}
		return null;
	}
}
