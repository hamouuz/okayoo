package com.gestionfacture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestionfacture.entity.Tva;

public interface TvaRepository extends JpaRepository<Tva, Long> {
    // Tu peux ajouter des méthodes personnalisées ici si nécessaire
}
