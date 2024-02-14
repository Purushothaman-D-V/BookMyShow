package com.springboot.bookmyshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.bookmyshow.dao.SeatDao;
import com.springboot.bookmyshow.entity.Seat;
import com.springboot.bookmyshow.util.ResponseStructure;

@Service
public class SeatService 
{
	@Autowired
	SeatDao seatDao;
	
	public ResponseEntity<ResponseStructure<Seat>> saveSeat(Seat seat)
	{
		Seat seatSaved = seatDao.saveSeat(seat);
		
		ResponseStructure<Seat> responseStructure = new ResponseStructure<Seat>();
		responseStructure.setMessage("Seat Saved Successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(seatSaved);
		
		return new ResponseEntity<ResponseStructure<Seat>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Seat>> findSeat(int seatId)
	{
		Seat seatFound = seatDao.findSeat(seatId);
		
		ResponseStructure<Seat> responseStructure = new ResponseStructure<Seat>();
		responseStructure.setMessage("Seat Found Successfully");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setData(seatFound);
		
		return new ResponseEntity<ResponseStructure<Seat>>(responseStructure,HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponseStructure<Seat>> deleteSeat(int seatId)
	{
		Seat seatDeleted = seatDao.deleteSeat(seatId);
		
		ResponseStructure<Seat> responseStructure = new ResponseStructure<Seat>();
		responseStructure.setMessage("Seat Deleted Successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(seatDeleted);
		
		return new ResponseEntity<ResponseStructure<Seat>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Seat>> updateSeat(Seat seat, int seatId)
	{
		Seat updatedSeat = seatDao.updateSeat(seat, seatId);
		
		ResponseStructure<Seat> responseStructure = new ResponseStructure<Seat>();
		responseStructure.setMessage("Screen Updated Successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(updatedSeat);
		
		return new ResponseEntity<ResponseStructure<Seat>>(responseStructure,HttpStatus.OK);
	}
}
