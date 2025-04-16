package tn.esprit.foyer.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.foyer.entities.Bloc;
import tn.esprit.foyer.entities.Chambre;
import tn.esprit.foyer.entities.TypeChambre;
import tn.esprit.foyer.repository.ChambreRepository;

import java.time.Year;
import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class ChambreServiceImpl implements IChambreService {
    @Autowired
    ChambreRepository chambreRepository;


    //@Scheduled(cron ="* */1 * * * *")
    public List<Chambre> retrieveAllChambres() {
        for (Chambre c: chambreRepository.findAll()) {
            log.info("Chambre - ID: {}, Numero: {}, Type: {}",
                    c.getIdChambre(), c.getNumeroChambre(), c.getTypeC());
        }
        return chambreRepository.findAll();
    }
    public Chambre retrieveChambre(Long chambreId) {
        return chambreRepository.findById(chambreId).get();

    }
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }
    public void removeChambre(Long chambreId) {
        chambreRepository.deleteById(chambreId);
    }
    public Chambre modifyChambre(Chambre chambre) {

        return chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> findbytypechambre(TypeChambre typeC) {
        return chambreRepository.findAllByTypeC(typeC);
    }

    @Override
    public Chambre findChambreByNumero(Long chambreid) {
        return chambreRepository.findChambreBynumeroChambre(chambreid);
    }

    @Override
    public Chambre trouverChselonEt(long cin) {
        return chambreRepository.trouverChselonEt(cin);
    }

/*
    @Scheduled(fixedDelay = 2000) // runs every minute
    public void logAllChambresWithBloc() {
        List<Chambre> chambres = chambreRepository.findAll();
        for (Chambre c : chambres) {
            log.info("Chambre - ID: {}, Numero: {}, Type: {}, Bloc: {}",
                    c.getIdChambre(),
                    c.getNumeroChambre(),
                    c.getTypeC(),
                    c.getBloc() != null ? c.getBloc().getIdBloc() + " nom bloc:" + c.getBloc().getNomBloc() : "Aucun Bloc");
        }
    }*/


    @Scheduled(cron = "0 */1 * * * *") // toutes les 5 minutes
    public void pourcentageChambreParTypeChambre() {
        List<Chambre> chambres = chambreRepository.findAll();
        int total = chambres.size();

        log.info("Nombre total des chambre: {}", total);

        for (TypeChambre type : TypeChambre.values()) {
            long count = chambres.stream()
                    .filter(c -> c.getTypeC() == type)
                    .count();

            double pourcentage = total == 0 ? 0.0 : ((double) count / total) * 100.0;

            log.info("Le pourcentage des chambres pour le type {} est égale à {}", type, pourcentage);
        }
    }

    @Scheduled(cron = "0 */5 * * * *") // every 5 minutes
    public void nbPlacesDisponibleParChambreAnneeEnCours() {
        List<Chambre> chambres = chambreRepository.findAll();
        int currentYear = Year.now().getValue(); // Assuming the academic year is the current calendar year

        for (Chambre chambre : chambres) {
            int capacite = chambre.();
            // This method should return the count of students assigned to that chambre in current year
            int nbOccupants = chambreRepository.countOccupantsByChambreAndAnnee(chambre.getIdChambre(), currentYear);
            int nbDisponible = capacite - nbOccupants;

            if (nbDisponible <= 0) {
                log.info("La chambre {} {} est complete", chambre.getTypeC(), chambre.getNumeroChambre());
            } else {
                log.info("Le nombre de place disponible pour la chambre {} {} est {}",
                        chambre.getTypeC(), chambre.getNumeroChambre(), nbDisponible);
            }
        }
    }

}

