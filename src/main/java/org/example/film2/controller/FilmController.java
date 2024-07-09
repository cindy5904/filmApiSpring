package org.example.film2.controller;

import org.example.film2.dto.FilmDtoGet;
import org.example.film2.dto.FilmDtoPost;
import org.example.film2.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("film")
public class FilmController {
    @Autowired
    private FilmService filmService;

    @GetMapping("")
    public ResponseEntity<List<FilmDtoGet>> getAll (){
        return ResponseEntity.ok(filmService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmDtoGet> getById (@PathVariable("id") int id){
        return ResponseEntity.ok(filmService.getById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<FilmDtoGet> createFilm (@RequestBody FilmDtoPost filmDtoPost){
        return ResponseEntity.status(HttpStatus.CREATED).body(filmService.create(filmDtoPost));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<FilmDtoGet> updateFilm (@PathVariable("id") int id,@RequestBody FilmDtoPost filmDtoPost){
        return ResponseEntity.ok(filmService.update(id,filmDtoPost));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFilm (@PathVariable("id") int id){
        filmService.delete(id);
        return ResponseEntity.ok("Film : "+id+" est supprimé");
    }



}
