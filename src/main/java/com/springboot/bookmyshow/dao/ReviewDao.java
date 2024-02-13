package com.springboot.bookmyshow.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.bookmyshow.entity.Review;
import com.springboot.bookmyshow.repo.ReviewRepo;

@Repository
public class ReviewDao 
{
	@Autowired
	ReviewRepo reviewRepo;
	
	public Review saveReview(Review review)
	{
		return reviewRepo.save(review);
	}
	
	public Review findReview(int reviewId)
	{
		Optional<Review> optional = reviewRepo.findById(reviewId);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;	
	}
	
	public Review deleteReview(int reviewId)
	{
		Review reviewFound = findReview(reviewId);
		if(reviewFound!=null)
		{
			reviewRepo.deleteById(reviewId);
			return reviewFound;
		}
		return null;
	}
	
	public Review updateReview(Review review, int reviewId)
	{
		Review reviewFound = findReview(reviewId);
		if(reviewFound!=null)
		{
			reviewFound.setReviewId(reviewId);
			reviewFound.setReview(review.getReview());
			reviewFound.setRatings(review.getRatings());
			reviewFound.setReviewUserId(review.getReviewUserId());
			return reviewRepo.save(reviewFound);
		}
		return null;
	}
}
