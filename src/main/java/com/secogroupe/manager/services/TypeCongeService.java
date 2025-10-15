package com.secogroupe.manager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secogroupe.manager.models.TypeConge;
import com.secogroupe.manager.repositorys.TypeCongeRepository;

@Service
public class TypeCongeService {

    private final TypeCongeRepository typeCongeRepository;

    @Autowired
    public TypeCongeService(TypeCongeRepository typeCongeRepository) {
        this.typeCongeRepository = typeCongeRepository;
    }

    public List<TypeConge> getAllTypeConges() {
        return typeCongeRepository.findAll();
    }

    public TypeConge getTypeCongeById(Integer id) {
        return typeCongeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TypeConge non trouvé avec id: " + id));
    }

    public TypeConge createTypeConge(TypeConge typeConge) {
        return typeCongeRepository.save(typeConge);
    }

    public TypeConge updateTypeConge(Integer id, TypeConge typeConge) {
        if (!typeCongeRepository.existsById(id)) {
            throw new RuntimeException("TypeConge non trouvé avec id: " + id);
        }
        typeConge.setId(id);
        return typeCongeRepository.save(typeConge);
    }

    public void deleteTypeConge(Integer id) {
        typeCongeRepository.deleteById(id);
    }
}