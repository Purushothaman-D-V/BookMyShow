package com.springboot.bookmyshow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bookmyshow.entity.Movie;
import com.springboot.bookmyshow.service.MovieService;
import com.springboot.bookmyshow.util.ResponseStructure;

@RestController
@RequestMapping("movie")
public class MovieController 
{
	@Autowired
	MovieService movieService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Movie>> saveMovie(Movie movie)
	{
		return movieService.saveMovie(movie);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Movie>> findMovie(int movieId)
	{
		return movieService.findMovie(movieId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Movie>> deleteBooking(int movieId)
	{
		return movieService.deleteMovie(movieId);
	}
	
	@PutMapping
	public ResponseEntity<ResponseStructure<Movie>> updateBooking(Movie movie, int movieId)
	{
		return movieService.updateMovie(movie, movieId);
	}

}
