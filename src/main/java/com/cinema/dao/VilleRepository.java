package com.cinema.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cinema.entities.Cinema;
import com.cinema.entities.Ville;

@RepositoryRestResource
@CrossOrigin("http://localhost:4200")
public interface VilleRepository extends JpaRepository<Ville, Long>{
	public Page<Ville> findByNameContains(String keyword, Pageable pageable);
}
