package com.springboot.bookmyshow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.bookmyshow.entity.Movie;
import com.springboot.bookmyshow.repo.MovieRepo;

@Repository
public class MovieDao 
{
	@Autowired
	MovieRepo movieRepo;
	
	public Movie saveMovie(Movie movie)
	{
		return movieRepo.save(movie);
	}
	
	public Movie findMovie(int movieId)
	{
		Optional<Movie> optional = movieRepo.findById(movieId);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}
	
	public Movie deleteMovie(int movieId)
	{
		Movie movieFound = findMovie(movieId);
		if(movieFound!=null)
		{
			movieRepo.delete(movieFound);
			return movieFound;
		}
		return null;
	}
	
	public Movie updateMovie(Movie movie, int movieId)
	{
		Movie movieFound = findMovie(movieId);
		if(movieFound!=null)
		{
			movieFound.setMovieId(movieId);
			movieFound.setMovieName(movie.getMovieName());
			movieFound.setRating(movie.getRating());
			movieFound.setReview(movie.getReview());
			return movieRepo.save(movieFound);
		}
		return null;
	}
}
