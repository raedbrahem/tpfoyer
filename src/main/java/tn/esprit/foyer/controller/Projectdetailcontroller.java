package tn.esprit.foyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyer.entities.Etudiant;
import tn.esprit.foyer.entities.ProjectDetail;
import tn.esprit.foyer.service.IProjectService;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/projectdetail")

public class Projectdetailcontroller {
    @Autowired
    IProjectService projectService;
    @PostMapping("/add-project")
    public ProjectDetail addprojectdetail(@RequestBody ProjectDetail e) {
        return projectService.addProjectdetaill(e);
    }
}
