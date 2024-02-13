package com.springboot.bookmyshow.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Component
public class Ticket 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketId;
	private String movieName;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Seat> seat;
	//private Movie movie;
	private Status status;

}
