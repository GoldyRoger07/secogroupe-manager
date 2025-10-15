package com.secogroupe.manager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.secogroupe.manager.models.Departement;
import com.secogroupe.manager.services.DepartementService;

@RestController
@RequestMapping("/secogroupe-manager/api/departements")
@CrossOrigin("*")
public class DepartementController {

    private final DepartementService departementService;

    @Autowired
    public DepartementController(DepartementService departementService) {
        this.departementService = departementService;
    }

    @GetMapping("")
    public List<Departement> getAllDepartements() {
        return departementService.getAllDepartements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departement> getDepartementById(@PathVariable Integer id) {
        return ResponseEntity.ok(departementService.getDepartementById(id));
    }

    @PostMapping("")
    public ResponseEntity<Departement> createDepartement(@RequestBody Departement departement) {
        Departement created = departementService.createDepartement(departement);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departement> updateDepartement(@PathVariable Integer id, @RequestBody Departement departement) {
        return ResponseEntity.ok(departementService.updateDepartement(id, departement));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartement(@PathVariable Integer id) {
        departementService.deleteDepartement(id);
        return ResponseEntity.noContent().build();
    }
}