package org.example.film2.service;

import org.example.film2.dto.FilmDtoGet;
import org.example.film2.dto.FilmDtoPost;
import org.example.film2.entity.Film;
import org.example.film2.entity.Realisateur;
import org.example.film2.exception.NotFoundException;
import org.example.film2.repository.FilmRepository;
import org.example.film2.repository.RealisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private RealisateurRepository realisateurRepository;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public FilmDtoGet getById(int id){
        return filmTofilmDtoGet(findById(id));
    }

    public List<FilmDtoGet> findAll (){
        return filmListTofilmDtoList((List<Film>) filmRepository.findAll());
    }

    public FilmDtoGet create (FilmDtoPost filmDtoPost){


        Film film = Film.builder()
                .title(filmDtoPost.getTitle())
                .dateSortie(LocalDate.parse(filmDtoPost.getDateSortie(), dateFormatter))
                .description(filmDtoPost.getDescription())
                .duree(filmDtoPost.getDuree())
                .genre(filmDtoPost.getGenre())
                .build();

        filmRepository.save(film);
        return filmTofilmDtoGet(film);
    }

    public FilmDtoGet update (int id , FilmDtoPost filmDtoPost){
        Film film = findById(id);
        film.setTitle(filmDtoPost.getTitle());
        film.setDateSortie(LocalDate.parse(filmDtoPost.getDateSortie(), dateFormatter));
        film.setDescription(filmDtoPost.getDescription());
        film.setDuree(filmDtoPost.getDuree());
        film.setGenre(filmDtoPost.getGenre());


        filmRepository.save(film);
        return filmTofilmDtoGet(film);
    }

    public boolean delete (int id){
        Film film = findById(id);
        filmRepository.delete(film);
        return true;
    }
    public List<FilmDtoGet> findByRealisateur(int realisateurId) {
        Realisateur realisateur = realisateurRepository.findById(realisateurId)
                .orElseThrow(NotFoundException::new);
        return filmListTofilmDtoList(filmRepository.findByRealisateur(realisateur));
    }


    private Film findById (int id){
        return filmRepository.findById(id).orElseThrow(NotFoundException::new);
    }
    private FilmDtoGet filmTofilmDtoGet (Film film){
        return FilmDtoGet.builder()
                .id(film.getId())
                .title(film.getTitle())
                .dateSortie(film.getDateSortie())
                .description(film.getDescription())
                .duree(film.getDuree())
                .genre(film.getGenre())
                .build();
    }

    private List<FilmDtoGet> filmListTofilmDtoList(List<Film> filmList){
        return filmList.stream().map(this::filmTofilmDtoGet).collect(Collectors.toList());
    }

}
