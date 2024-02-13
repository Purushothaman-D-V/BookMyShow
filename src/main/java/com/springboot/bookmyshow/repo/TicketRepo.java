package com.springboot.bookmyshow.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.bookmyshow.entity.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Integer>
{

}
