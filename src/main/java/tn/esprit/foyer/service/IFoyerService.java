package tn.esprit.foyer.service;

import tn.esprit.foyer.entities.Foyer;

import java.util.List;

public interface IFoyerService {
    List<Foyer> retrieveAllFoyers();
    Foyer retrieveFoyer(Long foyerId);
    Foyer addFoyer(Foyer foyer);
    void removeFoyer(Long foyerId);
    Foyer modifyFoyer(Foyer foyer);
}
