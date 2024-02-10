package com.springboot.bookmyshow.entity;

import java.sql.Time;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Component
public class Booking 
{
	private String bookingMovieName;
	private String bookingDate;
	private Time bookingTime;
	private int bookingTicketCount;
	private int bookingTicketAmount;
}
