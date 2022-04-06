package com.epam.generalmodule.controllers;

import com.epam.moduls.Guns;
import com.epam.serv_repo.repo.GunsRepo;
import com.epam.serv_repo.service.GunsService;
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
public class GunsController {

@Autowired
    public  GunsRepo gunsRepo;

    @Autowired
    private GunsService gunsService;

    @GetMapping("/guns")
    public String guns(Model model) {
        List<Guns> guns = gunsRepo.findAll();
        model.addAttribute("guns", guns);
        return "guns/guns";
    }

    @GetMapping("/guns/add")
    public String gunsAdd() {
        return "guns/gunsAdd";
    }

    @PostMapping("/guns/add")
    public String gunsAdd(@ModelAttribute Guns guns) {
        gunsService.saveGuns(guns);
        return "redirect:/guns";
    }

    @GetMapping("/guns/{id}")
    public String gunsDetails(@PathVariable(value = "id") int id, Model model){
        if (!gunsRepo.existsById(id)){
            return "redirect:/guns";
        }
        Optional<Guns> guns = gunsService.findGunsById(id);
        List<Guns> guns1 = new ArrayList<>();
        guns.ifPresent(guns1::add);
        model.addAttribute("guns", guns1);
        return "guns/details";
    }

    @GetMapping("/guns/{id}/edit")
    public String gunsDetailsEdit(@PathVariable(value = "id") int id, Model model){
        if (!gunsRepo.existsById(id)){
            return "redirect:/guns";
        }
        Optional<Guns> guns = gunsService.findGunsById(id);
        List<Guns> guns1 = new ArrayList<>();
        guns.ifPresent(guns1::add);
        model.addAttribute("guns", guns1);
        return "guns/edit";
    }

    @PostMapping("/guns/{id}/edit")
    public String gunsIdEdit(@ModelAttribute Guns guns){
        gunsService.saveGuns(guns);
        return "redirect:/guns";
    }

    @PostMapping("/guns/{id}/remove")
    public String gunsDelete(@PathVariable(value = "id") int id){
        Guns guns = gunsService.findGunsById(id).orElseThrow();
        gunsService.deleteGuns(guns);
        return "redirect:/guns";
    }
}
