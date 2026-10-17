package com.edt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groupe")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Groupe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nom;

    private Integer effectif;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "filiere_id", nullable = false)
    @JsonIgnore
    private Filiere filiere;

    @JsonIgnore
    @OneToMany(mappedBy = "groupe")
    private List<Etudiant> etudiants = new ArrayList<>();

    /** Seance 0..* --- destinee a --- 1 Groupe */
    @JsonIgnore
    @OneToMany(mappedBy = "groupe")
    private List<Seance> seances = new ArrayList<>();
}
