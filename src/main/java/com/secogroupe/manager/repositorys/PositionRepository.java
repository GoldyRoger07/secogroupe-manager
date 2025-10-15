package com.secogroupe.manager.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secogroupe.manager.models.Position;

public interface PositionRepository extends JpaRepository<Position, Integer>{
    
}
