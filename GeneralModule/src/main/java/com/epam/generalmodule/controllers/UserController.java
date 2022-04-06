package com.epam.generalmodule.controllers;

import com.epam.moduls.User;
import com.epam.moduls.UserType;
import com.epam.serv_repo.repo.UserRepo;
import com.epam.serv_repo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String user(Model model) {
        List<User> user = userRepo.findAll();
        model.addAttribute("user", user);
        return "user/user";
    }

    @GetMapping("/user/add")
    public String userAdd() {
        return "user/addUser";
    }

  @PostMapping("/user/add")
  public String userAdd(@ModelAttribute User user) {
    user.setUserType(UserType.USER);
      userService.saveUser(user);
      return "redirect:/user";
    }

    @GetMapping("/user/{id}")
    public String userDetails(@PathVariable(value = "id") int id, Model model){
        if (!userRepo.existsById(id)){
            return "redirect:/user";
        }
        Optional<User> user = userService.findUserById(id);
        List<User> user1 = new ArrayList<>();
        user.ifPresent(user1::add);
        model.addAttribute("user", user1);
        return "user/userDetails";
    }

    @GetMapping("/user/{id}/edit")
    public String userDetailsEdit(@PathVariable(value = "id") int id, Model model){
        if (!userRepo.existsById(id)){
            return "redirect:/user";
        }
        Optional<User> user = userService.findUserById(id);
        List<User> user1 = new ArrayList<>();
        user.ifPresent(user1::add);
        model.addAttribute("user", user1);
        return "user/userEdit";
    }

    @PostMapping("/user/{id}/edit")
    public String userIdEdit(@ModelAttribute User user){
        user.setUserType(UserType.USER);
        userService.saveUser(user);
        return "redirect:/user";
    }

    @PostMapping("/user/{id}/remove")
    public String userDelete(@PathVariable(value = "id") int id){
        User user = userService.findUserById(id).orElseThrow();
        userService.deleteUser(user);
        return "redirect:/user";
    }
}