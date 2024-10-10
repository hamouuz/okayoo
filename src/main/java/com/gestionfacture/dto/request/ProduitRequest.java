package com.gestionfacture.dto.request;

import com.gestionfacture.entity.Tva;
import lombok.Data;

@Data
public class ProduitRequest {
    private String codeProduit;
    private String designation;
    private double prixUnitaireHt;
    private double tauxTva;
//    private Tva tva;
}
