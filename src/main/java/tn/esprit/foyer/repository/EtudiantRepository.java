package tn.esprit.foyer.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.foyer.entities.Chambre;
import tn.esprit.foyer.entities.Etudiant;
import tn.esprit.foyer.entities.TypeChambre;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    List<Etudiant> findAllBy();
    Etudiant findByCin(Long cinEtudiant);
    List<Etudiant> findByDateNaissanceAndEcole(LocalDate dateNaissance, String ecole);
}

