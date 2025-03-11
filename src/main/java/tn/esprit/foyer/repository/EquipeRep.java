package tn.esprit.foyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.foyer.entities.Equipe;

public interface EquipeRep extends JpaRepository<Equipe, Long> {
}
