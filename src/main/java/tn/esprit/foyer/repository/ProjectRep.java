package tn.esprit.foyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.foyer.entities.Project;

public interface ProjectRep extends JpaRepository<Project, Long>{
}
