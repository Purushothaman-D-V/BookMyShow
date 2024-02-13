package com.springboot.bookmyshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.bookmyshow.dao.BookingDao;
import com.springboot.bookmyshow.entity.Booking;
import com.springboot.bookmyshow.util.ResponseStructure;

@Service
public class BookingService 
{
	@Autowired
	BookingDao bookingDao;

	public ResponseEntity<ResponseStructure<Booking>> saveBooking(Booking booking)
	{
		Booking savedBooking = bookingDao.saveBooking(booking);
		
		ResponseStructure<Booking> responseStructure = new ResponseStructure<Booking>();
		responseStructure.setMessage("Booking Saved Successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(savedBooking);
		
		return new ResponseEntity<ResponseStructure<Booking>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Booking>> findBooking(int bookingId)
	{
		Booking bookingFound = bookingDao.findBooking(bookingId);
		
		ResponseStructure<Booking> responseStructure = new ResponseStructure<Booking>();
		responseStructure.setMessage("Booking Found Successfully");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setData(bookingFound);
		
		return new ResponseEntity<ResponseStructure<Booking>>(responseStructure,HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponseStructure<Booking>> deleteBooking(int bookingId)
	{
		Booking bookingDeleted = bookingDao.deleteBooking(bookingId);
		
		ResponseStructure<Booking> responseStructure = new ResponseStructure<Booking>();
		responseStructure.setMessage("Booking Deleted Successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(bookingDeleted);
		
		return new ResponseEntity<ResponseStructure<Booking>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Booking>> updateBooking(Booking booking, int bookingId)
	{
		Booking updatedBooking = bookingDao.updateBooking(booking, bookingId);
		
		ResponseStructure<Booking> responseStructure = new ResponseStructure<Booking>();
		responseStructure.setMessage("Booking Updated Successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(updatedBooking);
		
		return new ResponseEntity<ResponseStructure<Booking>>(responseStructure,HttpStatus.OK);
	}
}



