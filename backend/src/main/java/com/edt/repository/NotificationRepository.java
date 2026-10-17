package com.edt.repository;

import com.edt.entity.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByDestinatairesIdOrderByDateEnvoiDesc(Long utilisateurId);
    List<Notification> findByExpediteurIdOrderByDateEnvoiDesc(Long administrateurId);
}
