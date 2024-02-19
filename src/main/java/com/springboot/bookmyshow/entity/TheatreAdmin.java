package com.springboot.bookmyshow.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Component
public class TheatreAdmin 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int theatreAdminId;
	@NotNull(message = "TheatreAdmin Name cannot be Null")
	@NotBlank(message = "TheatreAdmin Name cannot be Blank")
	private String theatreAdminName;
	@NotNull(message = "TheatreAdmin Email cannot be Null")
	@NotBlank(message = "TheatreAdmin Email cannot be Blank")
	private String theatreAdminEmail;
	@NotNull(message = "TheatreAdmin Password cannot be Null")
	@NotBlank(message = "TheatreAdmin Password cannot be Blank")
	private String theatreAdminPassword;
	@OneToOne(cascade = CascadeType.ALL)
	private Theatre theatre;
}
