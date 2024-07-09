package org.example.film2.repository;

import org.example.film2.entity.Film;
import org.example.film2.entity.Realisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends CrudRepository<Film, Integer> {
    List<Film> findByRealisateur(Realisateur realisateur);
}
