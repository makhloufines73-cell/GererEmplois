package com.edt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "notification")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String message;

    @Column(name = "date_envoi", nullable = false)
    private LocalDateTime dateEnvoi = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "expediteur_id", nullable = false)
    @JsonIgnore
    private Administrateur expediteur;

    /** Notification 0..* --- destinee a --- 1..* Utilisateur */
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "notification_destinataire",
               joinColumns = @JoinColumn(name = "notification_id"),
               inverseJoinColumns = @JoinColumn(name = "utilisateur_id"))
    private Set<Utilisateur> destinataires = new HashSet<>();
}
