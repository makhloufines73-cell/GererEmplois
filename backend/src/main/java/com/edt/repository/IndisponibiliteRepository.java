package com.edt.repository;

import com.edt.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IndisponibiliteRepository extends JpaRepository<Indisponibilite, Long> {
    List<Indisponibilite> findByProfesseurId(Long professeurId);
    boolean existsByProfesseurIdAndCreneauId(Long professeurId, Long creneauId);
}
