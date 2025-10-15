package com.secogroupe.manager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.secogroupe.manager.models.TypeConge;
import com.secogroupe.manager.services.TypeCongeService;

@RestController
@RequestMapping("/api/typeconges")
public class TypeCongeController {

    private final TypeCongeService typeCongeService;

    @Autowired
    public TypeCongeController(TypeCongeService typeCongeService) {
        this.typeCongeService = typeCongeService;
    }

    @GetMapping
    public List<TypeConge> getAllTypeConges() {
        return typeCongeService.getAllTypeConges();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeConge> getTypeCongeById(@PathVariable Integer id) {
        return ResponseEntity.ok(typeCongeService.getTypeCongeById(id));
    }

    @PostMapping
    public ResponseEntity<TypeConge> createTypeConge(@RequestBody TypeConge typeConge) {
        TypeConge created = typeCongeService.createTypeConge(typeConge);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeConge> updateTypeConge(@PathVariable Integer id, @RequestBody TypeConge typeConge) {
        return ResponseEntity.ok(typeCongeService.updateTypeConge(id, typeConge));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeConge(@PathVariable Integer id) {
        typeCongeService.deleteTypeConge(id);
        return ResponseEntity.noContent().build();
    }
}