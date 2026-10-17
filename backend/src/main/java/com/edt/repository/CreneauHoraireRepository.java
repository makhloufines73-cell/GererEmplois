package com.edt.repository;

import com.edt.entity.*;
import com.edt.entity.enums.Jour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CreneauHoraireRepository extends JpaRepository<CreneauHoraire, Long> {
    List<CreneauHoraire> findByJourOrderByHeureDebut(Jour jour);
}
