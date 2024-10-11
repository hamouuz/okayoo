package com.gestionfacture.service;

import com.gestionfacture.dto.request.FactureRequest;
import com.gestionfacture.dto.request.ProduitRequest;
import com.gestionfacture.entity.Facture;
import com.gestionfacture.entity.Client;
import com.gestionfacture.entity.Produit;
import com.gestionfacture.repository.ClientRepository;
import com.gestionfacture.repository.FactureRepository;
import com.gestionfacture.repository.ProduitRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class FactureService {

    private final FactureRepository factureRepository;
    private final ClientRepository clientRepository;
    private final ProduitRepository produitRepository;

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

    Facture initFacture(FactureRequest factureRequest) {

        List<Produit> detailProduits = new ArrayList<>();
        double totalHt = 0;
        double totalTtc = 0;

        for (ProduitRequest produitRequest : factureRequest.getProduits()) {
            // Calculer les montants pour chaque produit en tenant compte de la quantité
            double montantHtProduit = produitRequest.getPrixUnitaireHt() * produitRequest.getQuantite();
            double montantTtcProduit = montantHtProduit * (1 + (produitRequest.getTauxTva() / 100));

            // Ajouter les montants aux totaux
            totalHt += montantHtProduit;
            totalTtc += montantTtcProduit;

            // Créer et sauvegarder le produit en tenant compte de la quantité
            detailProduits.add(produitRepository.save(Produit.builder()
                    .codeProduit(produitRequest.getCodeProduit())
                    .designation(produitRequest.getDesignation())
                    .prixUnitaireHt(produitRequest.getPrixUnitaireHt())
                    .tauxTva(produitRequest.getTauxTva())
                    .build())
            );
        }

        // Créer la facture et lui assigner les valeurs
        Facture facture = new Facture();
        facture.setRefFacture(factureRequest.getRefFacture());
        facture.setConditionsReglement(factureRequest.getConditionsReglement());

        // Assigner les dates de facturation et d'échéance
        facture.setDateFacturation(LocalDate.now());  // Utilise la date actuelle
        facture.setDateEcheance(LocalDate.now().plusMonths(1)); // Exemple, à adapter

        // Assigner les totaux calculés
        facture.setTotalHt(totalHt);
        facture.setTotalTtc(totalTtc);

        // Assigner les produits
        facture.setProduits(detailProduits);

        return facture;
    }

    public Facture createFacture(FactureRequest factureRequest) {
        log.info("factureRequest   {}", factureRequest);
        Facture facture = initFacture(factureRequest);

        // Enregistrement de la facture
        facture = factureRepository.save(facture);

        // Logs pour vérifier les valeurs calculées
        log.info("Total HT : {}, Total TTC : {}", facture.getTotalHt(), facture.getTotalTtc());
        log.info("Date de facturation : {}, Date d'échéance : {}", facture.getDateFacturation(), facture.getDateEcheance());

        return facture;
    }



//    Facture initFacture(FactureRequest factureRequest) {
//
//        List<Produit> detailProduits = new ArrayList<>();
//
//        for (ProduitRequest produitRequest : factureRequest.getProduits()) {
//            detailProduits.add( produitRepository.save(Produit.builder()
//                    .codeProduit(produitRequest.getCodeProduit())
//                    .designation(produitRequest.getDesignation())
//                    .prixUnitaireHt(produitRequest.getPrixUnitaireHt())
//                    .tauxTva(produitRequest.getTauxTva())
//                    .build())
//            );
//        }
//        Facture facture = new Facture();
//        facture.setRefFacture(factureRequest.getRefFacture());
//        facture.setConditionsReglement(facture.getConditionsReglement());
//        facture.setProduits(detailProduits);
//        return facture;
//    }
//
//    public Facture createFacture(FactureRequest factureRequest) {
//        log.info("factureRequest   {}", factureRequest);
//        Facture facture = initFacture(factureRequest);
//        facture = factureRepository.save(facture);
//        return facture;
//    }



    // Création d'une facture avec vérification du client et des produits
    // Création ou mise à jour d'une facture avec vérification du client et des produits
//    public Facture createFacture(Facture facture) {
//        try {
//            // Vérifier si le client existe
//            Client client = clientRepository.findById(facture.getClient().getId())
//                    .orElseThrow(() -> new RuntimeException("Client not found"));
//            facture.setClient(client);
//
//            // Si la facture existe déjà (par son id ou ref_facture), la récupérer
//            Optional<Facture> existingFacture = factureRepository.findById(facture.getId());
//            if (existingFacture.isPresent()) {
//                // Supprimer les anciennes relations entre la facture et les produits
//                factureProduitRepository.deleteByFacture(existingFacture.get());
//            }
//
//            // Initialiser une liste pour stocker les produits sans doublons
//            List<Produit> produits = new ArrayList<>();
//            double totalHt = 0;  // Variable pour stocker le total HT
//            double totalTtc = 0; // Variable pour stocker le total TTC
//
//            // Parcourir les produits de la facture
//            for (Produit produit : facture.getProduits()) {
//                // Récupérer le produit par son ID
//                Produit existingProduit = produitRepository.findById(produit.getId())
//                        .orElseThrow(() -> new RuntimeException("Produit not found"));
//
//                // Calcul du total HT pour chaque produit (prix unitaire HT * quantité)
//                double montantHtProduit = existingProduit.getPrixUnitaireHt() * produit.getQuantite();
//                totalHt += montantHtProduit;
//
//                // Calcul du total TTC pour chaque produit (HT + TVA)
//                double montantTtcProduit = montantHtProduit * (1 + (existingProduit.getTva().getTauxTva() / 100));
//                totalTtc += montantTtcProduit;
//
//                produits.add(existingProduit);
//            }
//
//            // Affecter les produits sans doublons à la facture
//            facture.setProduits(produits);
//
//            // Affecter les totaux calculés
//            facture.setTotalHt(totalHt);
//            facture.setTotalTtc(totalTtc);
//
//            // Sauvegarder la nouvelle facture ou mettre à jour l'existante
//            return factureRepository.save(facture);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException("Erreur lors de la création de la facture", e);
//        }
//    }


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
