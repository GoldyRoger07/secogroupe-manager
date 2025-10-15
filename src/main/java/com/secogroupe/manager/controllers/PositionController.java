package com.secogroupe.manager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.secogroupe.manager.models.Position;
import com.secogroupe.manager.services.PositionService;

@RestController
@RequestMapping("/secogroupe-manager/api/positions")
@CrossOrigin("*")
public class PositionController {

    private final PositionService positionService;

    @Autowired
    public PositionController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Position> getPositionById(@PathVariable Integer id) {
        return ResponseEntity.ok(positionService.getPositionById(id));
    }

    @PostMapping
    public ResponseEntity<Position> createPosition(@RequestBody Position position) {
        Position created = positionService.createPosition(position);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Position> updatePosition(@PathVariable Integer id, @RequestBody Position position) {
        return ResponseEntity.ok(positionService.updatePosition(id, position));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePosition(@PathVariable Integer id) {
        positionService.deletePosition(id);
        return ResponseEntity.noContent().build();
    }
}
