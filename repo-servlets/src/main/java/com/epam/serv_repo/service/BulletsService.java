package com.epam.serv_repo.service;

import com.epam.moduls.Bullets;
import com.epam.serv_repo.repo.BulletsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BulletsService {

    @Autowired
    public BulletsRepo bulletsRepo;

    public void saveBullets(Bullets bullets) {
        bulletsRepo.save(bullets);
    }

    public Optional<Bullets> findBulletsById(int id) {
        return bulletsRepo.findById(id);
    }

    // TODO: findAll we don't need here !!!

    public void deleteBullets(Bullets bullets) {
        bulletsRepo.delete(bullets);
    }
}
