package tn.esprit.foyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.foyer.entities.RedCrescent;
@Repository
public interface RedCrescentRepository extends JpaRepository<RedCrescent, Long> {
}
