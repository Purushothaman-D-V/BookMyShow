package com.springboot.bookmyshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.bookmyshow.dao.TicketDao;
import com.springboot.bookmyshow.entity.Ticket;
import com.springboot.bookmyshow.util.ResponseStructure;

@Service
public class TicketService 
{
	@Autowired
	TicketDao ticketDao;
	
	public ResponseEntity<ResponseStructure<Ticket>> saveTicket(Ticket ticket)
	{
		Ticket ticketSaved = ticketDao.saveTicket(ticket);
		
		ResponseStructure<Ticket> responseStructure = new ResponseStructure<Ticket>();
		responseStructure.setMessage("Ticket Saved Successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(ticketSaved);
		
		return new ResponseEntity<ResponseStructure<Ticket>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Ticket>> findTicket(int ticketId)
	{
		Ticket ticketFound = ticketDao.findTicket(ticketId);
		
		ResponseStructure<Ticket> responseStructure = new ResponseStructure<Ticket>();
		responseStructure.setMessage("Ticket Found Successfully");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setData(ticketFound);
		
		return new ResponseEntity<ResponseStructure<Ticket>>(responseStructure,HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponseStructure<Ticket>> deleteTicket(int ticketId)
	{
		Ticket ticketDeleted = ticketDao.deleteTicket(ticketId);
		
		ResponseStructure<Ticket> responseStructure = new ResponseStructure<Ticket>();
		responseStructure.setMessage("Ticket Deleted Successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(ticketDeleted);
		
		return new ResponseEntity<ResponseStructure<Ticket>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Ticket>> updateTicket(Ticket ticket, int ticketId)
	{
		Ticket updatedTicket = ticketDao.updateTicket(ticket, ticketId);
		
		ResponseStructure<Ticket> responseStructure = new ResponseStructure<Ticket>();
		responseStructure.setMessage("Ticket Updated Successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(updatedTicket);
		
		return new ResponseEntity<ResponseStructure<Ticket>>(responseStructure,HttpStatus.OK);
	}
}
