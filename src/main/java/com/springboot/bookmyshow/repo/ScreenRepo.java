package com.springboot.bookmyshow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bookmyshow.entity.Screen;

public interface ScreenRepo extends JpaRepository<Screen, Integer>
{

}
