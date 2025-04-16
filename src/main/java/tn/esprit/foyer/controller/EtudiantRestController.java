package tn.esprit.foyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyer.entities.Etudiant;
import tn.esprit.foyer.service.IEtudiantService;

import java.util.List;
@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantRestController {

@Autowired
    private  IEtudiantService etudiantService;

        @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> getEtudiants() {
        return etudiantService.retrieveAllEtudiants();
    }

    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Long etudiantId) {
        return etudiantService.retrieveEtudiant(etudiantId);
    }

    @PostMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        return etudiantService.addEtudiant(e);
    }

    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") Long etudiantId) {
        etudiantService.removeEtudiant(etudiantId);
    }

    @PutMapping("/modify-etudiant")
    public Etudiant modifyEtudiant(@RequestBody Etudiant e) {
        return etudiantService.modifyEtudiant(e);
    }

    @GetMapping("/find-etudiant-by-dateNaissance-and-ecole/{dateNaissance}/{ecole}")
    public List<Etudiant> findEtudiantByDateNaissanceAndEcole(
            @PathVariable("dateNaissance") String dateNaissance,
            @PathVariable("ecole") String ecole) {
        return etudiantService.findEtudiantByDateNaissanceAndEcole(dateNaissance, ecole);
    }

}
