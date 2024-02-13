package com.springboot.bookmyshow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bookmyshow.entity.Booking;

public interface BookingRepo extends JpaRepository<Booking, Integer>{

}
