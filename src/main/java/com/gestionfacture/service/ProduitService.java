package com.gestionfacture.service;

import com.gestionfacture.entity.Produit;
import com.gestionfacture.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    public Produit getProduitById(Long id) {
        return produitRepository.findById(id).orElseThrow(() -> new RuntimeException("Produit not found"));
    }

    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }

    public Produit updateProduit(Long id, Produit produitDetails) {
        Produit produit = getProduitById(id);
        produit.setDesignation(produitDetails.getDesignation());
        produit.setPrixUnitaireHt(produitDetails.getPrixUnitaireHt());
        produit.setTauxTva(produitDetails.getTauxTva());
        return produitRepository.save(produit);
    }
}
