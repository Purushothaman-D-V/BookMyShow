package com.springboot.bookmyshow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bookmyshow.entity.TheatreAdmin;

public interface TheatreAdminRepo extends JpaRepository<TheatreAdmin, Integer>
{

}
