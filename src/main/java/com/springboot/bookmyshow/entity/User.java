package com.springboot.bookmyshow.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Component
public class User 
{
	private int userId;
	private String userName;
	private String userEmail;
	private String userPassword;
	@OneToMany
	private List<Booking> booking;
}
