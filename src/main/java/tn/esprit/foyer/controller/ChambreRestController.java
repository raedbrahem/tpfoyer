package tn.esprit.foyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.foyer.entities.Chambre;
import tn.esprit.foyer.entities.Etudiant;
import tn.esprit.foyer.entities.Reservation;
import tn.esprit.foyer.entities.TypeChambre;
import tn.esprit.foyer.repository.ChambreRepository;
import tn.esprit.foyer.repository.EtudiantRepository;
import tn.esprit.foyer.repository.ReservationRepository;
import tn.esprit.foyer.service.IChambreService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreRestController {
    @Autowired
    IChambreService chambreService;
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    ChambreRepository chambreRepository;




    // http://localhost:8089/tpfoyer/chambre/retrieve-all-chambres
    @GetMapping("/retrieve-all-chambres")
    public List<Chambre> getChambres() {
        List<Chambre> listChambres = chambreService.retrieveAllChambres();
        return listChambres;
    }
    // http://localhost:8089/tpfoyer/chambre/retrieve-chambre/8
    @GetMapping("/retrieve-chambre/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable("chambre-id") Long chId) {
        Chambre chambre = chambreService.retrieveChambre(chId);
        return chambre;
    }
    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.addChambre(c);
        return chambre;
    }
    // http://localhost:8089/tpfoyer/chambre/remove-chambre/{chambre-id}
    @DeleteMapping("/remove-chambre/{chambre-id}")
    public void removeChambre(@PathVariable("chambre-id") Long chId) {
        chambreService.removeChambre(chId);
    }
    // http://localhost:8089/tpfoyer/chambre/modify-chambre
    @PutMapping("/modify-chambre")
    public Chambre modifyChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.modifyChambre(c);
        return chambre;
    }

    @GetMapping("/retrieve-chambreby-type/{type}")
    public List<Chambre> getChambresbytype(@PathVariable("type") TypeChambre  type) {
        List<Chambre> listChambres = chambreService.findbytypechambre(type);
        return listChambres;
    }
    @GetMapping("/retrieve-chambreby-num/{numero}")
    public List<Chambre> getChambresbyNumero(@PathVariable("numero") Long  numeroChambre) {
         Chambre list= chambreService.findChambreByNumero(numeroChambre);
        return List.of(list);
    }

    // http://localhost:8089/tpfoyer/chambre/retrieve-chambreby-etudiant/{cin}
    @GetMapping("/retrieve-chambreby-etudiant/{cin}")
    public Chambre getChambreByEtudiant(@PathVariable("cin") long cin) {
        return chambreService.trouverChselonEt(cin);
    }

/*
    @PostMapping("/assignChambreToEtudiant/{cin}")
    public Chambre assignChambreToEtudiant(@PathVariable Long cin, @RequestBody Chambre chambre) {
        // Find the student by CIN
        Etudiant etudiant = etudiantRepository.findByCin(cin);

        if (etudiant == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
        }

        // Save the Chambre first
        Chambre savedChambre = chambreRepository.save(chambre);

        // Find the reservations for this student
        List<Reservation> reservations = reservationRepository.findByEtudiants_Cin(cin);

        // Assign the Chambre to each reservation (add to reservations list)
        for (Reservation reservation : reservations) {
            // Add the chambre to the reservation's list of reservations in Chambre
            savedChambre.getReservations().add(reservation);
            reservation.setChambre(savedChambre);  // Make sure each reservation points to the chambre
            reservationRepository.save(reservation);
        }

        // Return the saved Chambre
        return savedChambre;
    }
*/
}