package com.edt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/** Nouvelle table : un departement regroupe des filieres, des professeurs et des matieres. */
@Entity
@Table(name = "departement")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Departement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 20)
    private String code;

    @Column(nullable = false, length = 150)
    private String nom;

    /** Chef de departement (optionnel) */
    @OneToOne
    @JoinColumn(name = "chef_id")
    @JsonIgnore
    private Professeur chef;

    @JsonIgnore
    @OneToMany(mappedBy = "departement")
    private List<Filiere> filieres = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "departement")
    private List<Professeur> professeurs = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "departement")
    private List<Matiere> matieres = new ArrayList<>();
}
