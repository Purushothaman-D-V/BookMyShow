package com.springboot.bookmyshow.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Component
public class Movie 
{
	private int movieId;
	private String movieName;
	private List<Review> review;
	private double rating;
}
