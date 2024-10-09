package com.gestionfacture.service;

import com.gestionfacture.entity.Facture;
import com.gestionfacture.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactureService {

    @Autowired
    private FactureRepository factureRepository;

    public List<Facture> getAllFactures() {
        return factureRepository.findAll();
    }

    public Facture getFactureById(Long id) {
        return factureRepository.findById(id).orElseThrow(() -> new RuntimeException("Facture not found"));
    }

    public Facture createFacture(Facture facture) {
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
