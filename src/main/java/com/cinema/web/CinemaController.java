package com.cinema.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cinema.dao.CategorieRepository;
import com.cinema.dao.CinemaRepository;
import com.cinema.dao.FilmRepository;
import com.cinema.dao.PlaceRepository;
import com.cinema.dao.ProjectionRepository;
import com.cinema.dao.SalleRepository;
import com.cinema.dao.SeanceRepository;
import com.cinema.dao.TicketRepository;
import com.cinema.dao.VilleRepository;
import com.cinema.entities.Categorie;
import com.cinema.entities.Cinema;
import com.cinema.entities.Film;
import com.cinema.entities.Place;
import com.cinema.entities.Projection;
import com.cinema.entities.Salle;
import com.cinema.entities.Seance;
import com.cinema.entities.Ticket;
import com.cinema.entities.Ville;

@Controller
public class CinemaController {
	
	@Autowired
	private VilleRepository villeRepository;
	@Autowired
	private CinemaRepository cinemaRepository;
	@Autowired
	private SalleRepository salleRepository;
	@Autowired
	private PlaceRepository placeRepository;
	@Autowired
	private SeanceRepository seanceRepository;
	@Autowired
	private FilmRepository filmRepository;
	@Autowired
	private ProjectionRepository projectionRepository;
	@Autowired
	private CategorieRepository categorieRepository;
	@Autowired
	private TicketRepository ticketRepository;
	
	
	@GetMapping("/index")
	public String index() {
		
		return "index";
	}
	@GetMapping("/villesgest")
	public String villes(Model model,
			@RequestParam(name="page", defaultValue = "0")int page,
			@RequestParam(name="size", defaultValue = "5") int size,
			@RequestParam(name="keyword", defaultValue = "") String keyword) {
		Page<Ville> villes = villeRepository.findByNameContains(keyword, PageRequest.of(page,size));
		model.addAttribute("villes",villes.getContent());
		model.addAttribute("pages", new int[villes.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("keyword", keyword);
		return "villesGest";
	}
	@GetMapping("/cinemasgest")
	public String cinemas(Model model, 
			@RequestParam(name="page", defaultValue = "0")int page,
			@RequestParam(name="size", defaultValue = "5") int size,
			@RequestParam(name="ville", defaultValue = "1") Long ville,
			@RequestParam(name="keyword", defaultValue = "") String keyword) {
		Ville currentVille = villeRepository.findById(ville).get();
		//Page<Cinema> cinemas = cinemaRepository.findByNameAndVille(keyword, currentVille, PageRequest.of(page,size));
		//Page<Cinema> cinemas = cinemaRepository.findByNameContains(keyword, PageRequest.of(page,size));
		Page<Cinema> cinemas = cinemaRepository.findByVilleAndNameContains(currentVille, keyword, PageRequest.of(page,size));
		model.addAttribute("cinemas", cinemas.getContent());
		model.addAttribute("pages", new int[cinemas.getTotalPages()]);
		model.addAttribute("currentPage", page);
		model.addAttribute("keyword", keyword);
		model.addAttribute("ville", ville);
		return "cinemasGest";
	}
	@GetMapping("/sallesgest")
	public String salles(Model model) {
		List<Salle> salles = salleRepository.findAll();
		model.addAttribute("salles",salles);
		return "sallesGest";
	}
	@GetMapping("/seancesgest")
	public String seances(Model model) {
		List<Seance> seances = seanceRepository.findAll();
		model.addAttribute("seances",seances);
		return "seancesGest";
	}
	@GetMapping("/filmsgest")
	public String films(Model model) {
		List<Film> films = filmRepository.findAll();
		model.addAttribute("films",films);
		return "filmsGest";
	}
	@GetMapping("/categoriesgest")
	public String categories(Model model) {
		List<Categorie> categories = categorieRepository.findAll();
		model.addAttribute("categories",categories);
		return "categoriesGest";
	}
	@GetMapping("/projectionsgest")
	public String projections(Model model) {
		List<Projection> projections = projectionRepository.findAll();
		model.addAttribute("projections",projections);
		return "projectionsGest";
	}
	@GetMapping("/ticketsgest")
	public String tickets(Model model) {
		List<Ticket> tickets = ticketRepository.findAll();
		model.addAttribute("tickets",tickets);
		return "ticketsGest";
	}
	@GetMapping("/placesgest")
	public String places(Model model) {
		List<Place> places = placeRepository.findAll();
		model.addAttribute("places",places);
		return "placesGest";
	}
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("film",new Film());
		return "form";
	}
	@PostMapping("/savefilm")
	public String savefilm(Film film) {
		filmRepository.save(film);
		return "confirmation";
	}
	
	@GetMapping("/formville")
	public String formville(Model model) {
		model.addAttribute("ville",new Ville());
		return "formville";
	}
	@PostMapping("/saveville")
	public String saveville(Ville ville) {
		villeRepository.save(ville);
		return "confirmation";
	}
	@GetMapping("/editville")
	public String editville(Model model,Long id) {
		Ville v=villeRepository.findById(id).get();
		model.addAttribute("ville",v);
		return "formville";
	}
	
	

}
