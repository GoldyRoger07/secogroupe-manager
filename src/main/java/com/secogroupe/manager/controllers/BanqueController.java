package com.secogroupe.manager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.secogroupe.manager.models.Banque;
import com.secogroupe.manager.services.BanqueService;

@RestController
@RequestMapping("/api/banques")
public class BanqueController {

    private final BanqueService banqueService;

    @Autowired
    public BanqueController(BanqueService banqueService) {
        this.banqueService = banqueService;
    }

    @GetMapping
    public List<Banque> getAllBanques() {
        return banqueService.getAllBanques();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Banque> getBanqueById(@PathVariable Integer id) {
        return ResponseEntity.ok(banqueService.getBanqueById(id));
    }

    @PostMapping
    public ResponseEntity<Banque> createBanque(@RequestBody Banque banque) {
        Banque created = banqueService.createBanque(banque);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Banque> updateBanque(@PathVariable Integer id, @RequestBody Banque banque) {
        return ResponseEntity.ok(banqueService.updateBanque(id, banque));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBanque(@PathVariable Integer id) {
        banqueService.deleteBanque(id);
        return ResponseEntity.noContent().build();
    }
}