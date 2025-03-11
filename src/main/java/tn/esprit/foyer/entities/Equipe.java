package tn.esprit.foyer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity



public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String nom;

    public void setId(long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDomaine(Domaine domaine) {
        domaine = domaine;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
    @JsonIgnore
    @Enumerated(EnumType.STRING)
    Domaine domaine;

    public Equipe() {
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDomaine() {
        return domaine.toString();
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public Equipe(long id, String nom, tn.esprit.foyer.entities.Domaine domaine, Set<Project> projects) {
        this.id = id;
        this.nom = nom;
        domaine = domaine;
        this.projects = projects;
    }

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    public Set<Project> projects=new HashSet<Project>();
}
