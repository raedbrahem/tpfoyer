package tn.esprit.foyer.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.foyer.entities.Etudiant;
import tn.esprit.foyer.repository.EtudiantRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService {

@Autowired
    private  EtudiantRepository etudiantRepository;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant retrieveEtudiant(Long etudiantId) {
        return etudiantRepository.findById(etudiantId).orElse(null);
    }

    @Override
    public Etudiant addEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public void removeEtudiant(Long etudiantId) {
        etudiantRepository.deleteById(etudiantId);
    }

    @Override
    public Etudiant modifyEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> findEtudiantByDateNaissanceAndEcole(String dateNaissance, String ecole) {
        LocalDate parsedDate = LocalDate.parse(dateNaissance, DateTimeFormatter.ISO_DATE);
        return etudiantRepository.findByDateNaissanceAndEcole(parsedDate, ecole);
    }

}
