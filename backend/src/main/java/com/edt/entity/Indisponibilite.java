package com.edt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "indisponibilite")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Indisponibilite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String motif;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "professeur_id", nullable = false)
    @JsonIgnore
    private Professeur professeur;

    /** Indisponibilite 0..* --- concerne --- 1 CreneauHoraire */
    @ManyToOne(optional = false)
    @JoinColumn(name = "creneau_id", nullable = false)
    private CreneauHoraire creneau;
}
