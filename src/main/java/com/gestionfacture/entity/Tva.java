package com.gestionfacture.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data // Utilisation de Lombok pour générer les getters/setters/constructeurs
public class Tva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private double tauxTva;
}
