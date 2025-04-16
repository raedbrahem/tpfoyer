package tn.esprit.foyer.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.foyer.entities.Bloc;
import tn.esprit.foyer.entities.Chambre;
import tn.esprit.foyer.entities.ProjectDetail;
import tn.esprit.foyer.entities.TypeChambre;

import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {

    // No need to code CRUD here. It is already provided by the Spring Data JPA interfaces:
    // - CrudRepository
    // - PagingAndSortingRepository
    // - JpaRepository


    List<Chambre> findAllByTypeC(TypeChambre   typeC);
    public Chambre findChambreBynumeroChambre(Long numeroChambre);

    @Query("SELECT c FROM Chambre c WHERE c.numeroChambre = :numeroChambre")
    Chambre findChambreByNumeroChambre(@Param("numeroChambre") Long numeroChambre);

    @Query("SELECT DISTINCT ch FROM Chambre ch " +
            "INNER JOIN ch.reservations r " +
            "INNER JOIN r.etudiants e " +
            "WHERE e.cin = :cin")
    Chambre trouverChselonEt(@Param("cin") long cin);

    List<Chambre> findByBloc(Bloc bloc);
}