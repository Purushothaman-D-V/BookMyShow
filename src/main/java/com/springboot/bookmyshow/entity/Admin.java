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
public class Admin 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	@NotNull(message = "Admin Name Cannot be Null")
	@NotBlank(message = "Admin Name Cannot be Blank")
	private String adminName;
	@NotNull(message = "Admin Mail Cannot be NUll")
	@NotBlank(message = "Admin Mail Cannot be Blank")
	private String adminMail;
	@NotNull(message = "Admin Password Cannot be Null")
	@NotBlank(message = "Admin Password Cannot be Blank")
	private String adminPassword;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Theatre> theatre;

}
