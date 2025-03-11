package tn.esprit.foyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.foyer.entities.ProjectDetail;
import tn.esprit.foyer.service.ProjectService;

@Repository
public interface ProjectDETRep extends JpaRepository<ProjectDetail, Long>{
}
