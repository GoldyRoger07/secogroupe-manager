package com.secogroupe.manager.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secogroupe.manager.models.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Integer>{
    
}
