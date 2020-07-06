package com.cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.cinema.entities.Film;
import com.cinema.entities.Salle;
import com.cinema.entities.Ticket;
import com.cinema.service.ICinemaInitService;

@SpringBootApplication
public class CinemaProjectApplication implements CommandLineRunner {
	@Autowired
	private RepositoryRestConfiguration restConfiguration;
	@Autowired
	private ICinemaInitService cinemaInitService;

	public static void main(String[] args) {

		SpringApplication.run(CinemaProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		restConfiguration.exposeIdsFor(Film.class, Salle.class, Ticket.class);
		cinemaInitService.initVilles();
		cinemaInitService.initCinemas();
		cinemaInitService.initSalles();
		cinemaInitService.initPlaces();
		cinemaInitService.initSeances();
		cinemaInitService.initCategories();
		cinemaInitService.initFilms();
		cinemaInitService.initProjections();
		cinemaInitService.initTickets();
	}

}
