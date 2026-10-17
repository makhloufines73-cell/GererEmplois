package com.edt.repository;

import com.edt.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfesseurRepository extends JpaRepository<Professeur, Long> {
    Optional<Professeur> findByEmail(String email);
    List<Professeur> findByDepartementId(Long departementId);
    List<Professeur> findBySpecialiteContainingIgnoreCase(String specialite);
}
