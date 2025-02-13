package org.example.film2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RealisateurDoGet {
    private int id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String nationalite;
    private List<FilmDtoGet> films;
}
