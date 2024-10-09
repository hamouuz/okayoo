package com.gestionfacture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestionfacture.entity.Facture;

public interface FactureRepository extends JpaRepository<Facture, Long> {
    // Tu peux ajouter des méthodes personnalisées ici si nécessaire
}
