package com.edt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "administrateur")
@PrimaryKeyJoinColumn(name = "id")
@Getter @Setter @NoArgsConstructor
public class Administrateur extends Utilisateur {

    /** Administrateur 1 --- cree et publie --- 0..* EmploiDuTemps */
    @JsonIgnore
    @OneToMany(mappedBy = "administrateur")
    private List<EmploiDuTemps> emploisDuTemps = new ArrayList<>();

    /** Administrateur 1 --- envoie --- 0..* Notification */
    @JsonIgnore
    @OneToMany(mappedBy = "expediteur")
    private List<Notification> notificationsEnvoyees = new ArrayList<>();
}
