package tn.esprit.foyer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.foyer.entities.Equipe;
import tn.esprit.foyer.entities.Etudiant;
import tn.esprit.foyer.entities.Project;
import tn.esprit.foyer.entities.ProjectDetail;
import tn.esprit.foyer.repository.ChambreRepository;
import tn.esprit.foyer.repository.EquipeRep;
import tn.esprit.foyer.repository.ProjectDETRep;
import tn.esprit.foyer.repository.ProjectRep;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProjectService implements IProjectService {
    @Autowired
    ProjectRep projectRep;
    @Autowired
    EquipeRep equipeRep;
    @Autowired
    ProjectDETRep projectDETRep;

    @Override
    public List<Project> retrieveAllProjects() {
        return projectRep.findAll();
    }

    @Override
    public Project retrieveProjects(Long id) {
        return projectRep.findById(id).get();
    }

    @Override
    public Project addProjects(Project P) {
        return projectRep.save(P);
    }

    @Override
    public void removeProjects(Long id) {
        projectRep.deleteById(id);

    }

    @Override
    public Project modifyProjects(Project project) {
        return projectRep.save(project);
    }
///////////////////////////////////////////////Equipe 2///////////////////////////////////////////////
    @Override
    public List<Equipe> getAllEquipes() {
        return equipeRep.findAll();
    }

    @Override
    public Equipe getEquipeByID(Long id) {
        return equipeRep.findById(id).get();
    }

    @Override
    public Equipe addEquipe(Equipe equipe) {
        return equipeRep.save(equipe);
    }

    @Override
    public void removeEquipe(Long id) {
        equipeRep.deleteById(id);

    }

    @Override
    public Equipe modifyEquipe(Equipe equipe) {
        return equipeRep.save(equipe);
    }

    @Override
    public ProjectDetail addProjectdetaill(ProjectDetail projectDetail) {
        return projectDETRep.save(projectDetail);
    }


    public void assignProjetDetailToProjet(Long projetId, Long projetDetailId) {
        Project projet = projectRep.findById(projetId).get();
        ProjectDetail projetDetail = projectDETRep.findById(projetDetailId).get();
// on set le fils dans le parent :
        projet.setProjectDetail(projetDetail);
        projectRep.save(projet);
    }


    public void assignProjetToEquipe(Long projetId, Long equipeId) {
        Project projet = projectRep.findById(projetId).get();
        Equipe equipe = equipeRep.findById(equipeId).get();
// on set le fils dans le parent :
        equipe.getProjects().add(projet);
        equipeRep.save(equipe);
    }

    @Override
    public Project addProjetAndAssignProjetToProjetDetail(Project projet, Long projetDetailId) {
        ProjectDetail projetDetail = projectDETRep.findById(projetDetailId).get();
// on set le fils dans le parent :
        projet.setProjectDetail(projetDetail);
        return projectRep.save(projet);

    }

    @Override
    public Project DesaffecterProjetDetailFromProjet(Long projetId) {
        Project projet = projectRep.findById(projetId).get();
        projet.setProjectDetail(null);
        return projectRep.save(projet);

    }

    @Override
    public void desaffecterProjetFromEquipe(Long projetId, Long equipeId) {
        Project projet = projectRep.findById(projetId).get();
        Equipe equipe = equipeRep.findById(equipeId).get();
// on enlève le fils du parent :
        equipe.getProjects().remove(projet);
        equipeRep.save(equipe);

    }


}
