package tn.esprit.foyer.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.foyer.entities.Bloc;
import tn.esprit.foyer.entities.Foyer;
import tn.esprit.foyer.entities.TypeChambre;

import java.util.List;

@Repository
public interface BlocRepository extends JpaRepository<Bloc, Long> {

    // No need to code CRUD here. It is already provided by the Spring Data JPA interfaces:
    // - CrudRepository
    // - PagingAndSortingRepository
    // - JpaRepository
}