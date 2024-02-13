package com.springboot.bookmyshow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.bookmyshow.dao.ReviewDao;
import com.springboot.bookmyshow.entity.Review;
import com.springboot.bookmyshow.util.ResponseStructure;

@Service
public class ReviewService 
{
	@Autowired
	ReviewDao reviewDao;
	
	public ResponseEntity<ResponseStructure<Review>> saveReview(Review review)
	{
		Review reviewSaved = reviewDao.saveReview(review);
		
		ResponseStructure<Review> responseStructure = new ResponseStructure<Review>();
		responseStructure.setMessage("Review Saved Successfully");
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setData(reviewSaved);
		
		return new ResponseEntity<ResponseStructure<Review>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Review>> findReview(int reviewId)
	{
		Review reviewFound = reviewDao.findReview(reviewId);
		
		ResponseStructure<Review> responseStructure = new ResponseStructure<Review>();
		responseStructure.setMessage("Review Found Successfully");
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setData(reviewFound);
		
		return new ResponseEntity<ResponseStructure<Review>>(responseStructure,HttpStatus.FOUND);
	}
	
	public ResponseEntity<ResponseStructure<Review>> deleteReview(int reviewId)
	{
		Review reviewDeleted = reviewDao.deleteReview(reviewId);
		
		ResponseStructure<Review> responseStructure = new ResponseStructure<Review>();
		responseStructure.setMessage("Movie Deleted Successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(reviewDeleted);
		
		return new ResponseEntity<ResponseStructure<Review>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Review>> updateReview(Review review, int reviewId)
	{
		Review updatedReview = reviewDao.updateReview(review, reviewId);
		
		ResponseStructure<Review> responseStructure = new ResponseStructure<Review>();
		responseStructure.setMessage("Movie Updated Successfully");
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(updatedReview);
		
		return new ResponseEntity<ResponseStructure<Review>>(responseStructure,HttpStatus.OK);
	}

}
