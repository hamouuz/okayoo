package com.gestionfacture.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data // Utilisation de Lombok pour générer les getters/setters/constructeurs
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codeProduit;
    private String designation;
    private double prixUnitaireHt;
    private double tauxTva;

    private int quantite;  // Ajout du champ quantité

    // Relation ManyToOne avec Tva
    @ManyToOne
    @JoinColumn(name = "tva_id")
    private Tva tva;
}





/*package com.gestionfacture.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data // Utilisation de Lombok pour générer les getters/setters/constructeurs
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codeProduit;
    private String designation;
    private double prixUnitaireHt;
    private double tauxTva;

    // Relation ManyToOne avec Tva
    @ManyToOne
    @JoinColumn(name = "tva_id")
    private Tva tva;
}
*/