package com.gestionfacture.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;  // Import nécessaire pour List

@Entity
@Data // Utilisation de Lombok pour générer les getters/setters/constructeurs
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String refFacture;
    private Date dateFacturation;
    private Date dateEcheance;
    private double totalHt;
    private double totalTtc;
    private String conditionsReglement;

    // Relation ManyToOne avec Client
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    // Relation OneToMany avec Produit (pour plusieurs produits dans une facture)
    @OneToMany(cascade = CascadeType.ALL)
    private List<Produit> produits;  // Liste des produits dans une facture
}
