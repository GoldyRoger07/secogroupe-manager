package com.secogroupe.manager.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secogroupe.manager.models.TypeConge;

public interface TypeCongeRepository extends JpaRepository<TypeConge, Integer> {
    // add custom query methods if needed
}