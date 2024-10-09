package com.gestionfacture.controller;

import com.gestionfacture.entity.Tva;
import com.gestionfacture.service.TvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tva")
public class TvaController {

    @Autowired
    private TvaService tvaService;

    @GetMapping
    public List<Tva> getAllTva() {
        return tvaService.getAllTva();
    }

    @GetMapping("/{id}")
    public Tva getTvaById(@PathVariable Long id) {
        return tvaService.getTvaById(id);
    }

    @PostMapping
    public Tva createTva(@RequestBody Tva tva) {
        return tvaService.createTva(tva);
    }

    @PutMapping("/{id}")
    public Tva updateTva(@PathVariable Long id, @RequestBody Tva tvaDetails) {
        return tvaService.updateTva(id, tvaDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteTva(@PathVariable Long id) {
        tvaService.deleteTva(id);
    }
}
