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

import com.springboot.bookmyshow.entity.Booking;
import com.springboot.bookmyshow.service.BookingService;
import com.springboot.bookmyshow.util.ResponseStructure;

@RestController
@RequestMapping("booking")
public class BookingController 
{
	@Autowired
	BookingService bookingService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Booking>> saveBooking(@RequestBody Booking booking)
	{
		return bookingService.saveBooking(booking);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Booking>> findBooking(@RequestParam int bookingId)
	{
		return bookingService.findBooking(bookingId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Booking>> deleteBooking(@RequestParam int bookingId)
	{
		return bookingService.deleteBooking(bookingId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Booking>> updateBooking(@RequestBody Booking booking,@RequestBody int bookingId)
	{
		return bookingService.updateBooking(booking, bookingId);
	}
}



