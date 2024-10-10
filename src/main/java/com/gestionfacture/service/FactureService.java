package com.gestionfacture.service;

import com.gestionfacture.entity.Facture;
import com.gestionfacture.entity.Client;
import com.gestionfacture.entity.Produit;
import com.gestionfacture.repository.ClientRepository;
import com.gestionfacture.repository.FactureRepository;
import com.gestionfacture.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

import java.util.List;

@Service
public class FactureService {

    private final FactureRepository factureRepository;
    private final ClientRepository clientRepository;
    private final ProduitRepository produitRepository;

    // Injection par constructeur
    @Autowired
    public FactureService(FactureRepository factureRepository, ClientRepository clientRepository, ProduitRepository produitRepository) {
        this.factureRepository = factureRepository;
        this.clientRepository = clientRepository;
        this.produitRepository = produitRepository;
    }

    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }

    public Facture getFactureById(Long id) {
        return factureRepository.findById(id).orElseThrow(() -> new RuntimeException("Facture not found"));
    }

    // Création d'une facture avec vérification du client et des produits
    public Facture createFacture(Facture facture) {
        // Vérifier si le client existe
        Client client = clientRepository.findById(facture.getClient().getId())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        facture.setClient(client);

        // Vérifier si les produits existent et récupérer leurs informations
        List<Produit> produits = new ArrayList<>();
        for (Produit produit : facture.getProduits()) {
            Produit existingProduit = produitRepository.findById(produit.getId())
                    .orElseThrow(() -> new RuntimeException("Produit not found"));
            produits.add(existingProduit);
        }
        facture.setProduits(produits);

        // Sauvegarder la facture
        return factureRepository.save(facture);
    }

    public void deleteFacture(Long id) {
        factureRepository.deleteById(id);
    }

    public Facture updateFacture(Long id, Facture factureDetails) {
        Facture facture = getFactureById(id);
        facture.setDateEcheance(factureDetails.getDateEcheance());
        facture.setConditionsReglement(factureDetails.getConditionsReglement());
        facture.setTotalHt(factureDetails.getTotalHt());
        facture.setTotalTtc(factureDetails.getTotalTtc());
        return factureRepository.save(facture);
    }
}
