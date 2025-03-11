package tn.esprit.foyer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.ToString.Exclude;

import java.util.Date;

@Entity
public class ProjectDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     long id;
        String description;
        String technologie;
        Long cout;
        Date dateDebut;
        @OneToOne(mappedBy = "projectDetail")
        @JsonIgnore
        public Project project;

    public ProjectDetail(long id, String description, String technologie, Long cout, Date dateDebut, Project project) {
        this.id = id;
        this.description = description;
        this.technologie = technologie;
        this.cout = cout;
        this.dateDebut = dateDebut;
        this.project = project;
    }

    public ProjectDetail() {
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getTechnologie() {
        return technologie;
    }

    public Long getCout() {
        return cout;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Project getProject() {
        return project;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTechnologie(String technologie) {
        this.technologie = technologie;
    }

    public void setCout(Long cout) {
        this.cout = cout;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
