package com.gestionfacture.service;

import com.gestionfacture.entity.Tva;
import com.gestionfacture.repository.TvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TvaService {

    @Autowired
    private TvaRepository tvaRepository;

    public List<Tva> getAllTva() {
        return tvaRepository.findAll();
    }

    public Tva getTvaById(Long id) {
        return tvaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tva not found"));
    }

    public Tva createTva(Tva tva) {
        return tvaRepository.save(tva);
    }

    public void deleteTva(Long id) {
        tvaRepository.deleteById(id);
    }

    public Tva updateTva(Long id, Tva tvaDetails) {
        Tva tva = getTvaById(id);
        tva.setTauxTva(tvaDetails.getTauxTva());
        tva.setDate(tvaDetails.getDate());
        return tvaRepository.save(tva);
    }
}
