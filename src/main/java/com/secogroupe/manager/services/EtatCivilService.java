package com.secogroupe.manager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secogroupe.manager.models.EtatCivil;
import com.secogroupe.manager.repositorys.EtatCivilRepository;

@Service
public class EtatCivilService {

    private final EtatCivilRepository etatCivilRepository;

    @Autowired
    public EtatCivilService(EtatCivilRepository etatCivilRepository) {
        this.etatCivilRepository = etatCivilRepository;
    }

    public List<EtatCivil> getAllEtatCivils() {
        return etatCivilRepository.findAll();
    }

    public EtatCivil getEtatCivilById(Integer id) {
        return etatCivilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("EtatCivil non trouvé avec id: " + id));
    }

    public EtatCivil createEtatCivil(EtatCivil etatCivil) {
        return etatCivilRepository.save(etatCivil);
    }

    public EtatCivil updateEtatCivil(Integer id, EtatCivil etatCivil) {
        if (!etatCivilRepository.existsById(id)) {
            throw new RuntimeException("EtatCivil non trouvé avec id: " + id);
        }
        etatCivil.setId(id);
        return etatCivilRepository.save(etatCivil);
    }

    public void deleteEtatCivil(Integer id) {
        etatCivilRepository.deleteById(id);
    }
}