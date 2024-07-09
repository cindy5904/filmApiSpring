package org.example.film2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FilmDtoPost {
    private String title;
    private String dateSortie;
    private String description;
    private String duree;
    private String genre;
    private int realisateurId;
}
