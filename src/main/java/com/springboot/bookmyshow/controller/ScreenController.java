package com.springboot.bookmyshow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bookmyshow.entity.Screen;
import com.springboot.bookmyshow.service.ScreenService;
import com.springboot.bookmyshow.util.ResponseStructure;

@RestController
@RequestMapping("screen")
public class ScreenController 
{
	@Autowired
	ScreenService screenService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Screen>> saveScreen(Screen screen)
	{
		return screenService.saveScreen(screen);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Screen>> findScreen(int screenId)
	{
		return screenService.findScreen(screenId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Screen>> deleteReview(int screenId)
	{
		return screenService.deleteScreen(screenId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Screen>> updateBooking(Screen screen, int screenId)
	{
		return screenService.updateScreen(screen, screenId);
	}

}
