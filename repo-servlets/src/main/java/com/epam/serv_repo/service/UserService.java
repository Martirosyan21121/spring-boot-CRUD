package com.epam.serv_repo.service;

import com.epam.moduls.User;
import com.epam.serv_repo.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public void saveUser(User user) {
        userRepo.save(user);
    }

    public Optional<User> findUserById(int id) {
        return userRepo.findById(id);
    }

    // TODO: findAll we don't need here !!!

    public void deleteUser(User user) {
        userRepo.delete(user);
    }
}
