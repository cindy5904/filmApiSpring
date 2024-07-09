package org.example.film2.service;

import org.example.film2.dto.FilmDtoGet;
import org.example.film2.dto.FilmDtoPost;
import org.example.film2.dto.RealisateurDoGet;
import org.example.film2.dto.RealisateurDoPost;
import org.example.film2.entity.Film;
import org.example.film2.entity.Realisateur;
import org.example.film2.exception.NotFoundException;
import org.example.film2.repository.RealisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class RealisateurService {

    @Autowired
    private RealisateurRepository realisateurRepository;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public RealisateurDoGet getById(int id){
        return realisateurToRealisateurDtoGet(findById(id));
    }

    public List<RealisateurDoGet> findAll (){
        return reamisateurListToRealisateurDtoList((List<Realisateur>) realisateurRepository.findAll());
    }

    public RealisateurDoGet create (RealisateurDoPost realisateurDoPost){

        Realisateur realisateur = Realisateur.builder()
                .nom(realisateurDoPost.getNom())
                .prenom(realisateurDoPost.getPrenom())
                .dateNaissance(LocalDate.parse(realisateurDoPost.getDateNaissance(), dateFormatter))
                .nationalite(realisateurDoPost.getNationalite())
                .build();

        realisateurRepository.save(realisateur);
        return realisateurToRealisateurDtoGet(realisateur);
    }

    public RealisateurDoGet update (int id , RealisateurDoPost realisateurDoPost){
        Realisateur realisateur = findById(id);
        realisateur.setNom(realisateurDoPost.getNom());
        realisateur.setPrenom(realisateurDoPost.getPrenom());
        realisateur.setDateNaissance(LocalDate.parse(realisateurDoPost.getDateNaissance()));
        realisateur.setNationalite(realisateurDoPost.getNationalite());

        realisateurRepository.save(realisateur);
        return realisateurToRealisateurDtoGet(realisateur);
    }

    public boolean delete (int id){
        Realisateur realisateur = findById(id);
        realisateurRepository.delete(realisateur);
        return true;
    }


    private Realisateur findById (int id){
        return realisateurRepository.findById(id).orElseThrow(NotFoundException::new);
    }
    private RealisateurDoGet realisateurToRealisateurDtoGet (Realisateur realisateur){
        return RealisateurDoGet.builder()
                .id(realisateur.getId())
                .nom(realisateur.getNom())
                .prenom(realisateur.getPrenom())
                .dateNaissance(realisateur.getDateNaissance())
                .nationalite(realisateur.getNationalite())
                .build();
    }

    private List<RealisateurDoGet> reamisateurListToRealisateurDtoList(List<Realisateur> realisateurList){
        return realisateurList.stream().map(this::realisateurToRealisateurDtoGet).collect(Collectors.toList());
    }
}
