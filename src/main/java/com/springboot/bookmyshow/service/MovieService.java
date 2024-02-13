package com.springboot.bookmyshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.springboot.bookmyshow.dao.MovieDao;
import com.springboot.bookmyshow.entity.Movie;
import com.springboot.bookmyshow.util.ResponseStructure;

@Repository
public class MovieService 
{
	@Autowired
	MovieDao movieDao;
	
	public ResponseEntity<ResponseStructure<Movie>> saveMovie(Movie movie)
	{
		Movie movieSaved = movieDao.saveMovie(movie);
		
		ResponseStructure<Movie> responseStructure = new ResponseStructure<Movie>();
		responseStructure.setMessage("Movie Saved Successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(movieSaved);
		
		return new ResponseEntity<ResponseStructure<Movie>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Movie>> findMovie(int movieId)
	{
		Movie movieFound = movieDao.findMovie(movieId);
		
		ResponseStructure<Movie> responseStructure = new ResponseStructure<Movie>();
		responseStructure.setMessage("Movie Found Successfully");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setData(movieFound);
		
		return new ResponseEntity<ResponseStructure<Movie>>(responseStructure,HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponseStructure<Movie>> deleteMovie(int movieId)
	{
		Movie movieDeleted = movieDao.deleteMovie(movieId);
		
		ResponseStructure<Movie> responseStructure = new ResponseStructure<Movie>();
		responseStructure.setMessage("Movie Deleted Successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(movieDeleted);
		
		return new ResponseEntity<ResponseStructure<Movie>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Movie>> updateMovie(Movie movie, int movieId)
	{
		Movie updatedMovie = movieDao.updateMovie(movie, movieId);
		
		ResponseStructure<Movie> responseStructure = new ResponseStructure<Movie>();
		responseStructure.setMessage("Movie Updated Successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(updatedMovie);
		
		return new ResponseEntity<ResponseStructure<Movie>>(responseStructure,HttpStatus.OK);
	}

}
