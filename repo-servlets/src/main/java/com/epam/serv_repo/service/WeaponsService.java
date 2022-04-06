package com.epam.serv_repo.service;

import com.epam.moduls.Weapons;
import com.epam.serv_repo.repo.WeaponsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WeaponsService {

    @Autowired
    public WeaponsRepo weaponsRepo;

    public void saveWeapons(Weapons weapons) {
        weaponsRepo.save(weapons);
    }

    public Optional<Weapons> findWeaponsById(int id) {
        return weaponsRepo.findById(id);
    }

    // TODO: findAll we don't need here !!!

    public void deleteWeapons(Weapons weapons) {
        weaponsRepo.delete(weapons);
    }
}
