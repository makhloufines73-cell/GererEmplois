package com.edt.repository;

import com.edt.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmploiDuTempsRepository extends JpaRepository<EmploiDuTemps, Long> {
    List<EmploiDuTemps> findByPublieTrue();
    List<EmploiDuTemps> findBySemestre(String semestre);
    List<EmploiDuTemps> findByAdministrateurId(Long administrateurId);
}
