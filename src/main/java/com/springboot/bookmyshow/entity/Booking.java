package com.springboot.bookmyshow.entity;

import java.sql.Time;
import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Component
public class Booking 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	private String bookingMovieName;
	private String bookingDate;
	private Time bookingTime;
	private int bookingTicketCount;
	private int bookingTicketAmount;
	@OneToOne(cascade = CascadeType.ALL)
	private List<Ticket> ticket;
}
