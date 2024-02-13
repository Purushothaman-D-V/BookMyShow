package com.springboot.bookmyshow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.bookmyshow.entity.Ticket;
import com.springboot.bookmyshow.repo.TicketRepo;

@Repository
public class TicketDao 
{
	@Autowired
	TicketRepo ticketRepo;
	
	public Ticket saveTicket(Ticket ticket)
	{
		return ticketRepo.save(ticket);
	}

	public Ticket findTicket(int ticketId)
	{
		Optional<Ticket> optional = ticketRepo.findById(ticketId);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}
	
	public Ticket deleteTicket(int ticketId)
	{
		Ticket ticketFound = findTicket(ticketId);
		if(ticketFound!=null)
		{
			ticketRepo.deleteById(ticketId);
		}
		return ticketFound;
	}
	
	public Ticket updateTicket(Ticket ticket, int ticketId)
	{
		Ticket ticketFound = findTicket(ticketId);
		if(ticketFound!=null)
		{
			ticketFound.setTicketId(ticketId);
			ticketFound.setMovieName(ticket.getMovieName());
			ticketFound.setSeat(ticket.getSeat());
			ticketFound.setStatus(ticket.getStatus());
			return ticketRepo.save(ticketFound);
		}
		return null;
	}
}
