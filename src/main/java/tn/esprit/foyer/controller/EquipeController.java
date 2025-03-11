package tn.esprit.foyer.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyer.entities.Chambre;
import tn.esprit.foyer.entities.Equipe;
import tn.esprit.foyer.entities.Etudiant;
import tn.esprit.foyer.service.IProjectService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/equipe")

public class EquipeController {
     @Autowired
private IProjectService projectService;

    @GetMapping("/get-all-equipe")
    public List<Equipe> getEquipes() {
        return projectService.getAllEquipes();
    }
    @GetMapping("/get-equipe/{equipe-id}")
    public Equipe getEquipe(@PathVariable("equipe-id") Long id) {
        Equipe equipe = projectService.getEquipeByID(id);
        return equipe;
    }
    @PostMapping("/add-equipe")
    public Equipe addEquipe(@RequestBody Equipe c) {
        Equipe equipe = projectService.addEquipe(c);
        return equipe;
    }
    @DeleteMapping("/remove-equipe/{equipe-id}")
    public void removeEquipe(@PathVariable("equipe-id") Long id) {
        projectService.removeEquipe(id);
    }
    @PutMapping("/modify-equipe")
    public Equipe modifyEquipe(@RequestBody Equipe c) {
        Equipe equipe = projectService.modifyEquipe(c);
        return equipe;
    }

}
