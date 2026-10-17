package com.edt.repository;

import com.edt.entity.*;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeanceRepository extends JpaRepository<Seance, Long> {
    List<Seance> findByEmploiDuTempsId(Long emploiId);
    List<Seance> findByProfesseurId(Long professeurId);
    List<Seance> findByGroupeId(Long groupeId);
    List<Seance> findByGroupeIdAndDate(Long groupeId, LocalDate date);
    List<Seance> findByGroupeIdAndDateBetween(Long groupeId, LocalDate debut, LocalDate fin);

    // Detection de conflits (meme creneau + meme date)
    boolean existsBySalleIdAndCreneauIdAndDate(Long salleId, Long creneauId, LocalDate date);
    boolean existsByProfesseurIdAndCreneauIdAndDate(Long professeurId, Long creneauId, LocalDate date);
    boolean existsByGroupeIdAndCreneauIdAndDate(Long groupeId, Long creneauId, LocalDate date);
}
