package tn.esprit.foyer.service;

import tn.esprit.foyer.entities.Equipe;
import tn.esprit.foyer.entities.Etudiant;
import tn.esprit.foyer.entities.Project;
import tn.esprit.foyer.entities.ProjectDetail;

import java.util.List;

public interface IProjectService {
    List<Project> retrieveAllProjects();
    Project retrieveProjects(Long etudiantId);
    Project addProjects(Project project);
    void removeProjects(Long id);
    Project modifyProjects(Project project);
    ///////////////////////////Equipe 2///////////////////////////
    List<Equipe> getAllEquipes();
    Equipe getEquipeByID(Long id);
    Equipe addEquipe(Equipe equipe);
    void removeEquipe(Long id);
    Equipe modifyEquipe(Equipe equipe);
    ///////////////projetcdetaill////////
    ProjectDetail addProjectdetaill(ProjectDetail projectDetail);
    public void assignProjetDetailToProjet(Long projetId, Long projetDetailId);
    public void assignProjetToEquipe(Long projetId, Long equipeId);
    public Project addProjetAndAssignProjetToProjetDetail(Project projet, Long projetDetailId);
    public Project DesaffecterProjetDetailFromProjet(Long projetId);
    public void desaffecterProjetFromEquipe(Long projetId, Long equipeId);

}
