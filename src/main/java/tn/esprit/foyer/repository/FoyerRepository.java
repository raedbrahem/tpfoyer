package tn.esprit.foyer.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.foyer.entities.Foyer;
import tn.esprit.foyer.entities.TypeChambre;

import java.util.List;

@Repository
public interface FoyerRepository extends JpaRepository<Foyer, Long> {

    // No need to code CRUD here. It is already provided by the Spring Data JPA interfaces:
    // - CrudRepository
    // - PagingAndSortingRepository
    // - JpaRepository

    // You can add custom query methods here if needed
    List<Foyer> findAllBy();
}