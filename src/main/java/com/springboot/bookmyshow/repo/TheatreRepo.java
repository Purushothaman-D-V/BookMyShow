package com.springboot.bookmyshow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bookmyshow.entity.Theatre;

public interface TheatreRepo extends JpaRepository<Theatre, Integer>
{

}
