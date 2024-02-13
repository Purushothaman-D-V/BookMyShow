package com.springboot.bookmyshow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bookmyshow.entity.Theatre;
import com.springboot.bookmyshow.service.TheatreService;
import com.springboot.bookmyshow.util.ResponseStructure;

@RestController
@RequestMapping("theatre")
public class TheatreController 
{
	@Autowired
	TheatreService theatreService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Theatre>> saveTheatre(Theatre theatre )
	{
		return theatreService.saveTheatre(theatre);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Theatre>> findTheatreAdmin(int theatreId)
	{
		return theatreService.findTheatre(theatreId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Theatre>> deleteTheatre(int theatreId)
	{
		return theatreService.deleteTheatre(theatreId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Theatre>> updateBooking(Theatre theatre, int theatreId)
	{
		return theatreService.updateTheatre(theatre, theatreId);
	}
}
