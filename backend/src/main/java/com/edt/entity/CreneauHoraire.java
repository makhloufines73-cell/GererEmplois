package com.edt.entity;

import com.edt.entity.enums.Jour;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Table(name = "creneau_horaire",
       uniqueConstraints = @UniqueConstraint(columnNames = {"jour", "heure_debut", "heure_fin"}))
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class CreneauHoraire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private Jour jour;

    @Column(name = "heure_debut", nullable = false)
    private LocalTime heureDebut;

    @Column(name = "heure_fin", nullable = false)
    private LocalTime heureFin;
}
