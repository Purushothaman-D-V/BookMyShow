package com.springboot.bookmyshow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bookmyshow.entity.Movie;

public interface MovieRepo extends JpaRepository<Movie, Integer>{

}
