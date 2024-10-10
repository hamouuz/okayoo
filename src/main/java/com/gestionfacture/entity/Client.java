package com.gestionfacture.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Entity
@Data // Utilisation de Lombok pour générer les getters/setters/constructeurs
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codeClient;
    private String nom;
    private String adresse;
    private String telephone;
    private Date createdAt;

    // Relation OneToMany avec Facture
//    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
//    private List<Facture> factures;
}
