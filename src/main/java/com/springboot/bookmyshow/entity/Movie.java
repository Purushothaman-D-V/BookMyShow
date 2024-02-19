package com.springboot.bookmyshow.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
public class Movie 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieId;
	@NotNull(message = "Movie Name Cannot be Null")
	@NotBlank(message = "Movie Name Cannot be Blank")
	private String movieName;
	@OneToMany(cascade = CascadeType.ALL)
	@JsonProperty(access =  Access.WRITE_ONLY)
	private List<Review> review;
	private double rating;
}
