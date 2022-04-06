package com.epam.serv_repo.service;


import com.epam.moduls.BulletBox;
import com.epam.serv_repo.repo.BulletBoxRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BulletBoxService {

    @Autowired
    public BulletBoxRepo bulletBoxRepo;

    // TODO: save
    public void saveBulletBox(BulletBox bulletBox){
        bulletBoxRepo.save(bulletBox);
    }

    public Optional<BulletBox> findBulletBoxById(int id){
        return bulletBoxRepo.findById(id);
    }

    public void deleteBulletBox(BulletBox bulletBox){
        bulletBoxRepo.delete(bulletBox);
    }
}
