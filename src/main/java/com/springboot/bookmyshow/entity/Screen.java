package com.springboot.bookmyshow.entity;

import java.sql.Time;
import java.util.Date;

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
public class Screen 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int screenId; //Screen Number
	private Time screenTime;
	private Date screenDate;
	@OneToOne(cascade = CascadeType.ALL)
	private Movie movie;
	private Status status;
	//no of seats
}
