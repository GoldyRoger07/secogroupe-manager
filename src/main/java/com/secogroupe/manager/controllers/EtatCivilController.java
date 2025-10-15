package com.secogroupe.manager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.secogroupe.manager.models.EtatCivil;
import com.secogroupe.manager.services.EtatCivilService;

@RestController
@RequestMapping("/secogroupe-manager/api/etat-civils")
@CrossOrigin("*")
public class EtatCivilController {

    private final EtatCivilService etatCivilService;

    @Autowired
    public EtatCivilController(EtatCivilService etatCivilService) {
        this.etatCivilService = etatCivilService;
    }

    @GetMapping
    public List<EtatCivil> getAllEtatCivils() {
        return etatCivilService.getAllEtatCivils();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtatCivil> getEtatCivilById(@PathVariable Integer id) {
        return ResponseEntity.ok(etatCivilService.getEtatCivilById(id));
    }

    @PostMapping
    public ResponseEntity<EtatCivil> createEtatCivil(@RequestBody EtatCivil etatCivil) {
        EtatCivil created = etatCivilService.createEtatCivil(etatCivil);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EtatCivil> updateEtatCivil(@PathVariable Integer id, @RequestBody EtatCivil etatCivil) {
        return ResponseEntity.ok(etatCivilService.updateEtatCivil(id, etatCivil));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtatCivil(@PathVariable Integer id) {
        etatCivilService.deleteEtatCivil(id);
        return ResponseEntity.noContent().build();
    }
}
