package com.springboot.bookmyshow.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Component
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@NotNull(message = "User Name cannot be Null")
	@NotNull(message = "User Name cannot be Blank")
	private String userName;
	@NotNull(message = "User Email cannot be Null")
	@NotBlank(message = "User Email cannot be Blank")
	private String userEmail;
	@NotNull(message = "User Password cannot be Null")
	@NotBlank(message = "User Password cannot be Null")
	private String userPassword;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Booking> booking;
}
