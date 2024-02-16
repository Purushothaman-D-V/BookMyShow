package com.springboot.bookmyshow.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Component
public class Screen 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int screenId; //Screen Number
	private LocalTime screenTime;
	private LocalDate screenDate;
	private int noOfSeats;
	private Status status;
	private int theatreId;
	private int[] screenSeats;
	@ManyToOne(cascade = CascadeType.ALL)
	private Movie movie;
	@ManyToOne(cascade = CascadeType.ALL)
	private Theatre theatre;

}
