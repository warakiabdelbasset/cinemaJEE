package com.cinema.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cinema.entities.Categorie;

@RepositoryRestResource
@CrossOrigin("http://localhost:4200")
public interface CategorieRepository extends JpaRepository<Categorie, Long>{

}
