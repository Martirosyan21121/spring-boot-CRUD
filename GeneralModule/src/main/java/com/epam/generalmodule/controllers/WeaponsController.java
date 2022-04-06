package com.epam.generalmodule.controllers;

import com.epam.moduls.Weapons;
import com.epam.serv_repo.repo.WeaponsRepo;
import com.epam.serv_repo.service.WeaponsService;
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
public class WeaponsController {

    @Autowired
    private WeaponsRepo weaponsRepo;

    @Autowired
    private WeaponsService weaponsService;

    @GetMapping("/weapons")
    public String weapons(Model model) {
        List<Weapons> weapons = weaponsRepo.findAll();
        model.addAttribute("weapons", weapons);
        return "weapons/weapons";
    }

    @GetMapping("/weapons/add")
    public String weaponsAdd() {
        return "weapons/weaponsAdd";
    }

    @PostMapping("/weapons/add")
    public String weaponsAdd(@ModelAttribute Weapons weapons) {
        weaponsService.saveWeapons(weapons);
        return "redirect:/weapons";
    }

    @GetMapping("/weapons/{id}")
    public String weaponsDetails(@PathVariable(value = "id") int id, Model model){
        if (!weaponsRepo.existsById(id)){
            return "redirect:/weapons";
        }
        Optional<Weapons> weapons = weaponsService.findWeaponsById(id);
        List<Weapons> weapons1 = new ArrayList<>();
        weapons.ifPresent(weapons1::add);
        model.addAttribute("weapons", weapons1);
        return "weapons/details";
    }

    @GetMapping("/weapons/{id}/edit")
    public String weaponsDetailsEdit(@PathVariable(value = "id") int id, Model model){
        if (!weaponsRepo.existsById(id)){
            return "redirect:/weapons";
        }
        Optional<Weapons> weapons = weaponsService.findWeaponsById(id);
        List<Weapons> weapons1 = new ArrayList<>();
        weapons.ifPresent(weapons1::add);
        model.addAttribute("weapons", weapons1);
        return "weapons/edit";
    }

    @PostMapping("/weapons/{id}/edit")
    public String gunsIdEdit(@ModelAttribute Weapons weapons){
        weaponsService.saveWeapons(weapons);
        return "redirect:/weapons";
    }

    @PostMapping("/weapons/{id}/remove")
    public String weaponsDelete(@PathVariable(value = "id") int id){
        Weapons weapons = weaponsService.findWeaponsById(id).orElseThrow();
        weaponsService.deleteWeapons(weapons);
        return "redirect:/weapons";
    }
}
