package com.edt.repository;

import com.edt.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SalleRepository extends JpaRepository<Salle, Long> {
    Optional<Salle> findByNom(String nom);
    List<Salle> findByCapaciteGreaterThanEqual(Integer capacite);
    List<Salle> findByType(String type);
}
