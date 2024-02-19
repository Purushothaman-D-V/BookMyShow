package com.springboot.bookmyshow.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.bookmyshow.dao.BookingDao;
import com.springboot.bookmyshow.dao.ScreenDao;
import com.springboot.bookmyshow.dao.SeatDao;
import com.springboot.bookmyshow.dao.TicketDao;
import com.springboot.bookmyshow.dao.UserDao;
import com.springboot.bookmyshow.entity.Booking;
import com.springboot.bookmyshow.entity.Screen;
import com.springboot.bookmyshow.entity.Seat;
import com.springboot.bookmyshow.entity.SeatClass;
import com.springboot.bookmyshow.entity.Status;
import com.springboot.bookmyshow.entity.Ticket;
import com.springboot.bookmyshow.entity.User;
import com.springboot.bookmyshow.util.ResponseStructure;

@Service
public class BookingService 
{
	@Autowired
	BookingDao bookingDao;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ScreenDao screenDao;
	
	@Autowired
	SeatDao seatDao;
	
	@Autowired
	TicketDao ticketDao;
	
	@Autowired
	UserDao userDao;

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
	
	public ResponseEntity<ResponseStructure<Booking>> movieBooking(Booking booking, String userEmail, String userPassword, int screenId)
	{
		ResponseEntity<ResponseStructure<User>> user = userService.userLogin(userEmail, userPassword);
		
		ModelMapper mapper = new ModelMapper();
		User user1 = new User();
		mapper.map(user, user1);
		
		if(user!=null)
		{
			Screen screen = screenDao.findScreen(screenId);
			
			if(screen!=null)
			{
				Booking bookingMovie = new Booking();
				bookingMovie.setBookingMovieName(screen.getMovie().getMovieName());
				bookingMovie.setBookingDate(screen.getScreenDate());
				bookingMovie.setBookingTime(screen.getScreenTime());
				bookingMovie.setBookingTicketCount(booking.getBookingTicketCount());
				
				Ticket ticket = new Ticket();
				ticket.setMovieName(screen.getMovie().getMovieName());
				ticket.setStatus(Status.Pending);
				
				List<Seat> seatList = new ArrayList<Seat>();
				
				/*
				 * 
				//-->
				Screen screen2 = screenDao.findScreen(screenId);
				
				if(booking.getSeatClass()==SeatClass.FirstClass)
				{
					int availableSeats = 0;
					for(int i=0; i<((screen2.getScreenSeats().length)*0.2); i++)
					{
						availableSeats++;
					}
					if(availableSeats>booking.getBookingTicketCount())
					{
						for(int i=1; i<=booking.getBookingTicketCount(); i++)
						{
							Seat seat = new Seat();
							String seatNumber = "A";
							seat.setSeatNumber(seatNumber+i);
							seat.setSeatClass(booking.getSeatClass());
							seatList.add(seatDao.saveSeat(seat));
						}
					}
				}
				else if(booking.getSeatClass()==SeatClass.SecondClass)
				{
					for(int i=(int) ((screen2.getScreenSeats().length)*0.2); i<((screen2.getScreenSeats().length)*0.5); i++)
					{
						
					}
				}
				else if(booking.getSeatClass()==SeatClass.ThirdClass)
				{
					for(int i=(int) ((screen2.getScreenSeats().length)*0.5); i<screen2.getScreenSeats().length; i++)
					{
						
					}
				}
				//<--
				 * 
				 * 
				 */
				
				for(int i=1; i<=booking.getBookingTicketCount(); i++)
				{
					Seat seat = new Seat();
					seatList.add(seatDao.saveSeat(seat));
				}
				
				ticket.setSeat(seatList);
				
				Ticket savedTicket = ticketDao.saveTicket(ticket);
				
				bookingMovie.setTicket(savedTicket);
				
				Booking savedBooking = bookingDao.saveBooking(bookingMovie);
				
				Ticket ticketFound = ticketDao.findTicket(savedTicket.getTicketId());
				ticketFound.setBooking(savedBooking);
				
				ticketDao.updateTicket(ticketFound, ticketFound.getTicketId());
				
				//-->
				User userFound = userDao.findUser(user1.getUserId());
				List<Booking> bookingList = userFound.getBooking();
				bookingList.add(savedBooking);
				userFound.setBooking(bookingList);
				
				userDao.updateUser(userFound, userFound.getUserId());
				//<-- 
				
				ResponseStructure<Booking> responseStructure = new ResponseStructure<Booking>();
				responseStructure.setMessage("Booking done Successfully");
				responseStructure.setStatus(HttpStatus.CREATED.value());
				responseStructure.setData(savedBooking);
				
				return new ResponseEntity<ResponseStructure<Booking>>(responseStructure,HttpStatus.CREATED);
			}
			return null;
		}
		return null;
	}
}