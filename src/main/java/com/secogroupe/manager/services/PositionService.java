package com.secogroupe.manager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secogroupe.manager.models.Position;
import com.secogroupe.manager.repositorys.PositionRepository;

@Service
public class PositionService {

    private final PositionRepository positionRepository;

    @Autowired
    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    public Position getPositionById(Integer id) {
        return positionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Position non trouvée avec id: " + id));
    }

    public Position createPosition(Position position) {
        return positionRepository.save(position);
    }

    public Position updatePosition(Integer id, Position position) {
        if (!positionRepository.existsById(id)) {
            throw new RuntimeException("Position non trouvée avec id: " + id);
        }
        position.setId(id);
        return positionRepository.save(position);
    }

    public void deletePosition(Integer id) {
        positionRepository.deleteById(id);
    }
}