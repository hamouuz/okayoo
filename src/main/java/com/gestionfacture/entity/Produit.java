package com.gestionfacture.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Produit {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code_produit", nullable = false)
    private String codeProduit;

    @Column(name = "designation", nullable = false)
    private String designation;

    @Column(name = "prix_unitaire_ht", nullable = false)
    private double prixUnitaireHt;

    @Column(name = "taux_tva", nullable = false)
    private double tauxTva;

    @ManyToOne
    @JoinColumn(name = "id_facture", nullable = false)
    @JsonIgnore
    private Facture facture;

//    @ManyToOne
//    @JoinColumn(name = "tva_id")
//    private Tva tva;
}