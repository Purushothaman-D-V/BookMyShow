package com.springboot.bookmyshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.bookmyshow.dao.MovieDao;
import com.springboot.bookmyshow.dao.ScreenDao;
import com.springboot.bookmyshow.entity.Movie;
import com.springboot.bookmyshow.entity.Screen;
import com.springboot.bookmyshow.util.ResponseStructure;

@Service
public class ScreenService 
{
	@Autowired
	ScreenDao screenDao;
	
	@Autowired
	MovieDao movieDao;
	
	public ResponseEntity<ResponseStructure<Screen>> saveScreen(Screen screen)
	{
		Screen screenSaved = screenDao.saveScreen(screen);
		
		ResponseStructure<Screen> responseStructure = new ResponseStructure<Screen>();
		responseStructure.setMessage("Screen Saved Successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(screenSaved);
		
		return new ResponseEntity<ResponseStructure<Screen>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Screen>> findScreen(int screenId)
	{
		Screen screenFound = screenDao.findScreen(screenId);
		
		ResponseStructure<Screen> responseStructure = new ResponseStructure<Screen>();
		responseStructure.setMessage("Screen Found Successfully");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setData(screenFound);
		
		return new ResponseEntity<ResponseStructure<Screen>>(responseStructure,HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponseStructure<Screen>> deleteScreen(int screenId)
	{
		Screen screenDeleted = screenDao.deleteScreen(screenId);
		
		ResponseStructure<Screen> responseStructure = new ResponseStructure<Screen>();
		responseStructure.setMessage("Screen Deleted Successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(screenDeleted);
		
		return new ResponseEntity<ResponseStructure<Screen>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Screen>> updateScreen(Screen screen, int screenId)
	{
		Screen updatedScreen = screenDao.updateScreen(screen, screenId);
		
		ResponseStructure<Screen> responseStructure = new ResponseStructure<Screen>();
		responseStructure.setMessage("Screen Updated Successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(updatedScreen);
		
		return new ResponseEntity<ResponseStructure<Screen>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Screen>> addMovieToScreen(int movieId, int screenId)
	{
		Screen screenFound = screenDao.findScreen(screenId);
		Movie movieFound = movieDao.findMovie(movieId);
		
		screenFound.setMovie(movieFound);
		Screen updatedScreen = screenDao.updateScreen(screenFound, screenId);
		
		ResponseStructure<Screen> responseStructure = new ResponseStructure<Screen>();
		responseStructure.setMessage("Movie added to Screen Successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(updatedScreen);
		
		return new ResponseEntity<ResponseStructure<Screen>>(responseStructure,HttpStatus.OK);
	}

}
