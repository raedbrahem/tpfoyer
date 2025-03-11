package tn.esprit.foyer.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyer.entities.Project;
import tn.esprit.foyer.service.IProjectService;

import java.util.List;

@Tag(name="gestion de project")
@RestController

@RequestMapping("/project")
public class ProjectRestController {
    @Autowired
    IProjectService projectService;

    public ProjectRestController(IProjectService projectService) {
        this.projectService = projectService;
    }

    @Operation(description = "get all project")
    @GetMapping("/retrieve-all-project")
    public List<Project> getProject() {
        List<Project> listProject = projectService.retrieveAllProjects();
        return listProject;
    }

    @GetMapping("/retrieve-project/{project-id}")
    public Project retrieveProject(@PathVariable("project-id") Long id) {
        Project project = projectService.retrieveProjects(id);
        return project;
    }

    @PostMapping("/add-project")
    public Project addProject(@RequestBody Project p) {
        Project project = projectService.addProjects(p);
        return project;
    }

    @DeleteMapping("/remove-project/{project-id}")
    public void removeProject(@PathVariable("project-id") Long chId) {
        projectService.removeProjects(chId);
    }



    @PutMapping("/modify-project")
    public Project modifyProject(@RequestBody Project p) {
        Project project = projectService.modifyProjects(p)  ;
        return project;
    }
    //localhost:8089/tp8/projet/affecter-projet-a-projet-details/1/1
    @PutMapping("/affecter-projet-a-projet-details/{projet-id}/{projet-details-id}")
    public void voidaffecgterProjetAProjetDetail(@PathVariable("projet-id") Long proejtId,
                                                 @PathVariable("projet-details-id") Long proejtDetailsId) {
        projectService.assignProjetDetailToProjet(proejtId, proejtDetailsId);
    }
    @PutMapping("/affecter-projet-a-equipe/{projet-id}/{equipe-id}")
    public void voidaffecterprojetequipe(@PathVariable("projet-id") Long proejtId,
                                                 @PathVariable("equipe-id") Long equipeId) {
        projectService.assignProjetToEquipe(proejtId, equipeId);
    }
    @PostMapping("/ajouter-projet-et-afffecter-projet-details-to-projet/{projet-detail_id}")
    public Project addProjetandAssignProjetDetail(
            @RequestBody Project p,
            @PathVariable("projet-detail_id") Long projetDetailsId) {
        Project projet = projectService.addProjetAndAssignProjetToProjetDetail(p, projetDetailsId);
        return projet;
    }

    @PutMapping("/desaffecter-projet-detail/{projetId}")
    public Project desaffecterProjetDetail(@PathVariable("projetId") Long projetId) {
        return projectService.DesaffecterProjetDetailFromProjet(projetId);
    }
    @PutMapping("/desaffecter-projet-de-equipe/{projet-id}/{equipe-id}")
    public void desaffecgterEqupeProjet(@PathVariable("projet-id") Long projtId , @PathVariable("equipe-id") Long equipeId) {
        projectService.desaffecterProjetFromEquipe(projtId, equipeId);
    }

}
