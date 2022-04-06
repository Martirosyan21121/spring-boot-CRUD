package com.epam.generalmodule.controllers;

import com.epam.moduls.BulletBox;
import com.epam.serv_repo.repo.BulletBoxRepo;
import com.epam.serv_repo.service.BulletBoxService;
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
public class BulletBoxController {


  @Autowired
  private BulletBoxRepo bulletBoxRepo;

  @Autowired
  private BulletBoxService bulletBoxService;

  @GetMapping("/bulletBox")
  public String bulletBox(Model model) {
    List<BulletBox> bulletBoxes = bulletBoxRepo.findAll();
    model.addAttribute("bulletBox", bulletBoxes);
    return "bulletBox/bulletBox";
  }

  @GetMapping("/bulletBox/add")
  public String bulletBoxAdd() {
    return "bulletBox/bulletBoxAdd";
  }

  @PostMapping("/bulletBox/add")
  public String bulletBoxAdd(@ModelAttribute BulletBox bulletBox) {

    bulletBoxService.saveBulletBox(bulletBox);
    return "redirect:/bulletBox";
  }

  @GetMapping("/bulletBox/{id}")
  public String bulletBoxDetails(@PathVariable(value = "id") int id, Model model) {
    if (!bulletBoxRepo.existsById(id)) {
      return "redirect:/bulletBox";
    }
    Optional<BulletBox> bulletBox = bulletBoxService.findBulletBoxById(id);
    List<BulletBox> bulletBoxes = new ArrayList<>();
    bulletBox.ifPresent(bulletBoxes::add);
    model.addAttribute("bulletBox", bulletBoxes);
    return "bulletBox/details";
  }

  @GetMapping("/bulletBox/{id}/edit")
  public String bulletBoxDetailsEdit(@PathVariable(value = "id") int id, Model model) {
    if (!bulletBoxRepo.existsById(id)) {
      return "redirect:/bulletBox";
    }
    Optional<BulletBox> bulletBox = bulletBoxService.findBulletBoxById(id);
    List<BulletBox> bulletBoxes = new ArrayList<>();
    bulletBox.ifPresent(bulletBoxes::add);
    model.addAttribute("bulletBox", bulletBoxes);
    return "bulletBox/edit";
  }

  @PostMapping("/bulletBox/{id}/edit")
  public String bulletBoxIdEdit(@ModelAttribute BulletBox bulletBox) {
    bulletBoxService.saveBulletBox(bulletBox);
    return "redirect:/bulletBox";
  }

  @PostMapping("/bulletBox/{id}/remove")
  public String bulletBoxDelete(@PathVariable(value = "id") int id) {
    BulletBox bulletBox = bulletBoxService.findBulletBoxById(id).orElseThrow();
    bulletBoxService.deleteBulletBox(bulletBox);
    return "redirect:/bulletBox";
  }
}
