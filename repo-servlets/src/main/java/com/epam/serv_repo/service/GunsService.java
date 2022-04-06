package com.epam.serv_repo.service;

import com.epam.moduls.Guns;
import com.epam.serv_repo.repo.GunsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GunsService {

    @Autowired
    public GunsRepo gunsRepo;

    public void saveGuns(Guns guns) {
        gunsRepo.save(guns);
    }

    public Optional<Guns> findGunsById(int id) {
        return gunsRepo.findById(id);
    }

    // TODO: findAll we don't need here !!!

    public void deleteGuns(Guns guns) {
        gunsRepo.delete(guns);
    }
}
