package com.edt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "emploi_du_temps")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class EmploiDuTemps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String semestre;

    @Column(nullable = false)
    private boolean publie = false;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "administrateur_id", nullable = false)
    @JsonIgnore
    private Administrateur administrateur;

    /** Composition : EmploiDuTemps 1 <>--- contient --- 0..* Seance */
    @JsonIgnore
    @OneToMany(mappedBy = "emploiDuTemps", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seance> seances = new ArrayList<>();

    public void addSeance(Seance s) { seances.add(s); s.setEmploiDuTemps(this); }
    public void removeSeance(Seance s) { seances.remove(s); s.setEmploiDuTemps(null); }
}
