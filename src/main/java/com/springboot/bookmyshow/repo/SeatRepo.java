package com.springboot.bookmyshow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bookmyshow.entity.Seat;

public interface SeatRepo extends JpaRepository<Seat, Integer>
{

}
