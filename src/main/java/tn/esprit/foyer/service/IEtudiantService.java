package tn.esprit.foyer.service;

import tn.esprit.foyer.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    List<Etudiant> retrieveAllEtudiants();
    Etudiant retrieveEtudiant(Long etudiantId);
    Etudiant addEtudiant(Etudiant etudiant);
    void removeEtudiant(Long etudiantId);
    Etudiant modifyEtudiant(Etudiant etudiant);
}
