package com.springboot.bookmyshow.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.bookmyshow.dao.ScreenDao;
import com.springboot.bookmyshow.dao.TheatreDao;
import com.springboot.bookmyshow.entity.Screen;
import com.springboot.bookmyshow.entity.Theatre;
import com.springboot.bookmyshow.entity.TheatreAdmin;
import com.springboot.bookmyshow.util.ResponseStructure;

@Service
public class TheatreService 
{
	@Autowired
	TheatreDao theatreDao;
	
	@Autowired
	ScreenDao screenDao;
	
	@Autowired
	TheatreAdminService theatreAdminService;
	
	public ResponseEntity<ResponseStructure<Theatre>> saveTheatre(Theatre theatre)
	{
		Theatre theatreSaved = theatreDao.saveTheatre(theatre);
		
		ResponseStructure<Theatre> responseStructure = new ResponseStructure<Theatre>();
		responseStructure.setMessage("Theatre Saved Successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(theatreSaved);
		
		return new ResponseEntity<ResponseStructure<Theatre>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Theatre>> findTheatre(int theatreId)
	{
		Theatre theatreFound = theatreDao.findTheatre(theatreId);
		
		ResponseStructure<Theatre> responseStructure = new ResponseStructure<Theatre>();
		responseStructure.setMessage("Theatre Found Successfully");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setData(theatreFound);
		
		return new ResponseEntity<ResponseStructure<Theatre>>(responseStructure,HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponseStructure<Theatre>> deleteTheatre(int theatreId)
	{
		Theatre theatreDeleted = theatreDao.deleteTheatre(theatreId);
		
		ResponseStructure<Theatre> responseStructure = new ResponseStructure<Theatre>();
		responseStructure.setMessage("Theatre Deleted Successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(theatreDeleted);
		
		return new ResponseEntity<ResponseStructure<Theatre>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Theatre>> updateTheatre(Theatre theatre, int theatreId)
	{
		Theatre updatedTheatre = theatreDao.updateTheatre(theatre, theatreId);
		
		ResponseStructure<Theatre> responseStructure = new ResponseStructure<Theatre>();
		responseStructure.setMessage("Theatre Updated Successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(updatedTheatre);
		
		return new ResponseEntity<ResponseStructure<Theatre>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Theatre>> addScreenToTheatre(int screenId, int theatreId, String theatreAdminEmail, String theatreAdminPassword)
	{
		ResponseEntity<ResponseStructure<TheatreAdmin>> theatreAdmin = theatreAdminService.theatreAdminLogin(theatreAdminEmail, theatreAdminPassword);
		
		ModelMapper mapper = new ModelMapper();
		TheatreAdmin theatreAdminDto = new TheatreAdmin();
		mapper.map(theatreAdmin, theatreAdminDto);
		
		if(theatreAdmin!=null)
		{
			Screen screenFound = screenDao.findScreen(screenId);
			Theatre theatreFound = theatreDao.findTheatre(theatreId);
			
			screenFound.setTheatreId(theatreId);
			screenFound.setTheatre(theatreFound);
			screenDao.updateScreen(screenFound, screenFound.getScreenId());
			List<Screen> screenList = theatreFound.getScreen();
			screenList.add(screenFound);
			
			theatreFound.setScreen(screenList);
			theatreFound.setTheatreAdmin(theatreAdminDto);
			Theatre updatedTheatre = theatreDao.updateTheatre(theatreFound, theatreId);
			
			if(updatedTheatre!=null)
			{
				ResponseStructure<Theatre> responseStructure = new ResponseStructure<Theatre>();
				responseStructure.setMessage("Theatre Updated Successfully");
				responseStructure.setStatus(HttpStatus.OK.value());
				responseStructure.setData(updatedTheatre);
				
				return new ResponseEntity<ResponseStructure<Theatre>>(responseStructure,HttpStatus.OK);
			}
			return null;
		}
		return null;
	}
}
