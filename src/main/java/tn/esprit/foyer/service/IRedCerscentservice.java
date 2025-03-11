package tn.esprit.foyer.service;

import tn.esprit.foyer.entities.Etudiant;
import tn.esprit.foyer.entities.RedCrescent;

import java.util.List;

public interface IRedCerscentservice {

    List<RedCrescent> getAllRed();
    RedCrescent getbyId(Long id);
    RedCrescent addRed(RedCrescent redCrescent);
    void removeRed(Long redId);
    RedCrescent modifyRed(RedCrescent redCrescent);
}
