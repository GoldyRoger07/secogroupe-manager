package com.secogroupe.manager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secogroupe.manager.models.Departement;
import com.secogroupe.manager.repositorys.DepartementRepository;

@Service
public class DepartementService {

    private final DepartementRepository departementRepository;

    @Autowired
    public DepartementService(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }

    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

    public Departement getDepartementById(Integer id) {
        return departementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Departement non trouvé avec id: " + id));
    }

    public Departement createDepartement(Departement departement) {
        return departementRepository.save(departement);
    }

    public Departement updateDepartement(Integer id, Departement departement) {
        if (!departementRepository.existsById(id)) {
            throw new RuntimeException("Departement non trouvé avec id: " + id);
        }
        // assure que l'entité a le bon id avant sauvegarde
        departement.setId(id);
        return departementRepository.save(departement);
    }

    public void deleteDepartement(Integer id) {
        departementRepository.deleteById(id);
    }
}