package com.epam.generalmodule.controllers;

import com.epam.moduls.Bullets;
import com.epam.serv_repo.repo.BulletsRepo;
import com.epam.serv_repo.service.BulletsService;
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
public class BulletsController {

 @Autowired
    private  BulletsRepo bulletsRepo;

    @Autowired
    private BulletsService bulletsService;

    @GetMapping("/bullets")
    public String bullets(Model model) {
        List<Bullets> bullets = bulletsRepo.findAll();
        model.addAttribute("bullet", bullets);
        return "bullets/bullets";
    }

    @GetMapping("/bullets/add")
    public String bulletsAdd() {
        return "bullets/bulletsAdd";
    }

    @PostMapping("/bullets/add")
    public String bulletsAdd(@ModelAttribute Bullets bullets) {
        bulletsService.saveBullets(bullets);
        return "redirect:/bullets";
    }

    @GetMapping("/bullets/{id}")
    public String bulletsDetails(@PathVariable(value = "id") int id, Model model){
        if (!bulletsRepo.existsById(id)){
            return "redirect:/bullets";
        }
        Optional<Bullets> bullets = bulletsService.findBulletsById(id);
        List<Bullets> bullets1 = new ArrayList<>();
        bullets.ifPresent(bullets1::add);
        model.addAttribute("bullets", bullets1);
        return "bullets/details";
    }

    @GetMapping("/bullets/{id}/edit")
    public String bulletsDetailsEdit(@PathVariable(value = "id") int id, Model model){
        if (!bulletsRepo.existsById(id)){
            return "redirect:/bullets";
        }
        Optional<Bullets> bullets = bulletsService.findBulletsById(id);
        List<Bullets> bullets1 = new ArrayList<>();
        bullets.ifPresent(bullets1::add);
        model.addAttribute("bullets", bullets1);
        return "bullets/edit";
    }

    @PostMapping("/bullets/{id}/edit")
    public String bulletsIdEdit(@ModelAttribute Bullets bullets){
        bulletsService.saveBullets(bullets);
        return "redirect:/bullets";
    }
    @PostMapping("/bullets/{id}/remove")
    public String bulletsDelete(@PathVariable(value = "id") int id){
        Bullets bullets = bulletsService.findBulletsById(id).orElseThrow();
        bulletsService.deleteBullets(bullets);
        return "redirect:/bullets";
    }
}
