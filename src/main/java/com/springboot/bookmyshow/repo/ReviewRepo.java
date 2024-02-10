package com.springboot.bookmyshow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bookmyshow.entity.Review;

public interface ReviewRepo extends JpaRepository<Review, Integer>
{

}
