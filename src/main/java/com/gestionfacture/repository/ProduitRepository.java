package com.gestionfacture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestionfacture.entity.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    // Tu peux ajouter des méthodes personnalisées ici si nécessaire
}
