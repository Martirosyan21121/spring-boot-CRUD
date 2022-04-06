package com.epam.serv_repo.repo;

import com.epam.moduls.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {

}
