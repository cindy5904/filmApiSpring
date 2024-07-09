package org.example.film2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.film2.entity.Realisateur;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FilmDtoGet {
    private int id;
    private String title;
    private LocalDate dateSortie;
    private String description;
    private String duree;
    private String genre;


}
