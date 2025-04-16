package tn.esprit.foyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.foyer.entities.ProjectDetail;
import tn.esprit.foyer.service.ProjectService;

import java.util.List;

@Repository
public interface ProjectDETRep extends JpaRepository<ProjectDetail, Long>{
    List<ProjectDetail> findByTechnologieLike(String technologie);
    List<ProjectDetail> findByTechnologieContains(String technologie);
    List<ProjectDetail> findByTechnologieContaining(String technologie);
}
