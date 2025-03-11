package tn.esprit.foyer.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.foyer.entities.Chambre;
import tn.esprit.foyer.entities.Foyer;
import tn.esprit.foyer.entities.TypeChambre;
import tn.esprit.foyer.entities.Universite;

import java.util.List;

@Repository
public interface UniversiteRepository extends JpaRepository<Universite, Long> {

    // No need to code CRUD here. It is already provided by the Spring Data JPA interfaces:
    // - CrudRepository
    // - PagingAndSortingRepository
    // - JpaRepository

    List<Universite> findAllByFoyerIsNull();
}