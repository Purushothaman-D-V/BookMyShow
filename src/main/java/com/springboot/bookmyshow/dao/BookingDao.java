package com.springboot.bookmyshow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.bookmyshow.entity.Booking;
import com.springboot.bookmyshow.repo.BookingRepo;

@Repository
public class BookingDao 
{
	@Autowired
	BookingRepo bookingrepo;
	
	public Booking saveBooking(Booking booking)
	{
		return bookingrepo.save(booking);
	}
	
	public Booking findBooking(int bookingId)
	{
		Optional<Booking> optional = bookingrepo.findById(bookingId);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}
	
	public Booking deleteBooking(int bookingId)
	{
		Booking bookingFound = findBooking(bookingId);
		if(bookingFound!=null)
		{
			bookingrepo.delete(bookingFound);
			return bookingFound;
		}
		return null;
	}
	
	public Booking updateBooking(Booking booking,int bookingId)
	{
		Booking bookingFound = findBooking(bookingId);
		if(bookingFound!=null)
		{
			bookingFound.setBookingId(bookingId);
			bookingFound.setBookingDate(booking.getBookingDate());
			bookingFound.setBookingMovieName(booking.getBookingMovieName());
			bookingFound.setBookingTicketAmount(booking.getBookingTicketAmount());
			bookingFound.setBookingTicketCount(booking.getBookingTicketCount());
			bookingFound.setBookingTime(booking.getBookingTime());
			
			Booking updatedBooking = bookingrepo.save(booking);
			return updatedBooking;
		}
		return null;
	}

}
