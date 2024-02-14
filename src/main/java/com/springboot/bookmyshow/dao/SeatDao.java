package com.springboot.bookmyshow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.bookmyshow.entity.Seat;
import com.springboot.bookmyshow.repo.SeatRepo;

@Repository
public class SeatDao 
{
	@Autowired
	SeatRepo seatRepo;

	public Seat saveSeat(Seat seat)
	{
		return seatRepo.save(seat);
	}
	
	public Seat findSeat(int seatId)
	{
		Optional<Seat> optional = seatRepo.findById(seatId);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}
	
	public Seat deleteSeat(int seatId)
	{
		Seat seatFound = findSeat(seatId);
		if(seatFound!=null)
		{
			seatRepo.deleteById(seatId);
			return seatFound;
		}
		return null;
	}
	
	public Seat updateSeat(Seat seat, int seatId)
	{
		Seat seatFound = findSeat(seatId);
		if(seatFound!=null)
		{
			seatFound.setSeatId(seatId);
			seatFound.setSeatClass(seat.getSeatClass());
			seatFound.setSeatNumber(seat.getSeatNumber());
			return seatRepo.save(seatFound);
		}
		return null;
	}
}
