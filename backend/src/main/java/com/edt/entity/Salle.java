package com.edt.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "salle")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String nom;

    private Integer capacite;

    /** ex : AMPHI, TD, TP */
    @Column(length = 30)
    private String type;
}
