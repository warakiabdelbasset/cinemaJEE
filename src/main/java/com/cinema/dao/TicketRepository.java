package com.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cinema.entities.Ticket;

@RepositoryRestResource
@CrossOrigin("http://localhost:4200")
public interface TicketRepository extends JpaRepository<Ticket, Long>{

}
