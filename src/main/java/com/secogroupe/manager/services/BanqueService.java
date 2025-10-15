package com.secogroupe.manager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secogroupe.manager.models.Banque;
import com.secogroupe.manager.repositorys.BanqueRepository;

@Service
public class BanqueService {

    private final BanqueRepository banqueRepository;

    @Autowired
    public BanqueService(BanqueRepository banqueRepository) {
        this.banqueRepository = banqueRepository;
    }

    public List<Banque> getAllBanques() {
        return banqueRepository.findAll();
    }

    public Banque getBanqueById(Integer id) {
        return banqueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Banque non trouvée avec id: " + id));
    }

    public Banque createBanque(Banque banque) {
        return banqueRepository.save(banque);
    }

    public Banque updateBanque(Integer id, Banque banque) {
        if (!banqueRepository.existsById(id)) {
            throw new RuntimeException("Banque non trouvée avec id: " + id);
        }
        banque.setId(id);
        return banqueRepository.save(banque);
    }

    public void deleteBanque(Integer id) {
        banqueRepository.deleteById(id);
    }
}