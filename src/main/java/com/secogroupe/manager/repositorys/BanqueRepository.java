package com.secogroupe.manager.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secogroupe.manager.models.Banque;

public interface BanqueRepository extends JpaRepository<Banque, Integer>{
    
}
