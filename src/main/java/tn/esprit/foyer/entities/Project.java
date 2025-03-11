package tn.esprit.foyer.entities;
import jakarta.persistence.*;
import java.util.Set;

@Entity

public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String sujet;
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "projects")
    public Set<Equipe> equipes;
    @OneToOne(cascade = CascadeType.ALL)
    public ProjectDetail projectDetail;

    public Project(int id, String sujet, Set<Equipe> equipes, ProjectDetail projectDetail) {
        this.id = id;
        this.sujet = sujet;
        this.equipes = equipes;
        this.projectDetail = projectDetail;
    }

    public Project() {

    }

    public int getId() {
        return id;
    }

    public String getSujet() {
        return sujet;
    }

    public Set<Equipe> getEquipes() {
        return equipes;
    }

    public ProjectDetail getProjectDetail() {
        return projectDetail;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public void setEquipes(Set<Equipe> equipes) {
        this.equipes = equipes;
    }

    public void setProjectDetail(ProjectDetail projectDetail) {
        this.projectDetail = projectDetail;
    }
}
