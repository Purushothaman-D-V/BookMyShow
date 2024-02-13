package com.springboot.bookmyshow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bookmyshow.entity.TheatreAdmin;
import com.springboot.bookmyshow.service.TheatreAdminService;
import com.springboot.bookmyshow.util.ResponseStructure;

@RestController
@RequestMapping("theatreadmin")
public class TheatreAdminController 
{
	@Autowired
	TheatreAdminService theatreAdminService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<TheatreAdmin>> saveTheatreAdmin(@RequestBody TheatreAdmin theatreAdmin )
	{
		return theatreAdminService.saveTheatreAdmin(theatreAdmin);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<TheatreAdmin>> findTheatreAdmin(@RequestParam int theatreAdminId)
	{
		return theatreAdminService.findTheatreAdmin(theatreAdminId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<TheatreAdmin>> deleteTheatreAdmin(@RequestParam int theatreAdminId)
	{
		return theatreAdminService.deleteTheatreAdmin(theatreAdminId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<TheatreAdmin>> updateBooking(@RequestBody TheatreAdmin theatreAdmin,@RequestParam int theatreAdminId)
	{
		return theatreAdminService.updateTheatreAdmin(theatreAdmin, theatreAdminId);
	}
	
	public ResponseEntity<ResponseStructure<TheatreAdmin>> theatreAdminLogin(@RequestParam String theatreAdminEmail,@RequestParam String theatreAdminPassword)
	{
		return theatreAdminService.theatreAdminLogin(theatreAdminEmail, theatreAdminPassword);
	}


}
