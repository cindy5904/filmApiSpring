package org.example.film2.controller;

import org.example.film2.dto.FilmDtoGet;
import org.example.film2.dto.FilmDtoPost;
import org.example.film2.dto.RealisateurDoGet;
import org.example.film2.dto.RealisateurDoPost;
import org.example.film2.service.FilmService;
import org.example.film2.service.RealisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("realisateur")
public class RealisateurController {
    @Autowired
    private RealisateurService realisateurService;

    @GetMapping("")
    public ResponseEntity<List<RealisateurDoGet>> getAll (){
        return ResponseEntity.ok(realisateurService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RealisateurDoGet> getById (@PathVariable("id") int id){
        return ResponseEntity.ok(realisateurService.getById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<RealisateurDoGet> createRealisateur (@RequestBody RealisateurDoPost realisateurDoPost){
        return ResponseEntity.status(HttpStatus.CREATED).body(realisateurService.create(realisateurDoPost));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<RealisateurDoGet> updateRealisateur (@PathVariable("id") int id,@RequestBody RealisateurDoPost realisateurDoPost){
        return ResponseEntity.ok(realisateurService.update(id,realisateurDoPost));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRealisateur (@PathVariable("id") int id){
        realisateurService.delete(id);
        return ResponseEntity.ok("realisateur : "+id+" est supprimé");
    }

}
