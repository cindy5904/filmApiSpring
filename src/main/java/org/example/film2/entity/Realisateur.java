package org.example.film2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Realisateur {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String nom;
        private String prenom;
        private LocalDate dateNaissance;
        private String nationalite;

        @OneToMany(fetch = FetchType.EAGER, mappedBy = "realisateur")
        private List<Film> films = new ArrayList<>();
}
