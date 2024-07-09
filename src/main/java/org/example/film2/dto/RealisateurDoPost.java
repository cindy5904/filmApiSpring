package org.example.film2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RealisateurDoPost {
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String nationalite;

}
