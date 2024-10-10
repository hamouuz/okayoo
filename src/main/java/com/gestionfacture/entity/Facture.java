package com.gestionfacture.entity;
import com.gestionfacture.entity.Client;
import com.gestionfacture.entity.Produit;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;  // Import nécessaire pour List

@Entity
@Data
@Table(name = "facture")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Facture {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ref_facture", nullable = false, length = 254)
    private String refFacture;

    @Column(name = "date_facturation", nullable = true)
    private LocalDate dateFacturation;

    @Column(name = "date_echeance", nullable = true)
    private LocalDate dateEcheance;

    @Column(name = "total_ht", nullable = false)
    private double totalHt;

    @Column(name = "total_ttc", nullable = false)
    private double totalTtc;

    @Column(name = "conditions_reglement", nullable = true, length = 254)
    private String conditionsReglement;

    // Relation ManyToOne avec Client
//    @ManyToOne
//    @JoinColumn(name = "client_id")
//    private Client client;

    // Relation OneToMany avec Produit (pour plusieurs produits dans une facture)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "facture_id", referencedColumnName = "id")
    private List<Produit> produits = new ArrayList<>();
}
