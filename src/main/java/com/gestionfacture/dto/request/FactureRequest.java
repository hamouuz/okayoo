package com.gestionfacture.dto.request;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class FactureRequest {
    private String refFacture;
    private Date dateFacturation;
    private Date dateEcheance;
    private double totalHt;
    private double totalTtc;
    private String conditionsReglement;
//    private Client client;
    private List<ProduitRequest> produits;
}
