package org.example.film2.repository;

import org.example.film2.entity.Realisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealisateurRepository extends CrudRepository<Realisateur, Integer> {

}
