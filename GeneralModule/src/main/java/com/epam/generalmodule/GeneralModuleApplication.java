package com.epam.generalmodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages = {"com.epam.serv_repo.repo"})
@EntityScan({"com.epam.moduls"})
@ComponentScan({"com.epam.generalmodule", "com.epam.moduls", "com.epam.serv_repo"})
@SpringBootApplication
public class GeneralModuleApplication {

  public static void main(String[] args) {
    SpringApplication.run(GeneralModuleApplication.class, args);

  }

}
