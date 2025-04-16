package tn.esprit.foyer.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.foyer.entities.Reservation;
import tn.esprit.foyer.repository.ReservationRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Slf4j
@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService {

    private  ReservationRepository reservationRepository;

    @Override
    public List<Reservation> retrieveAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation retrieveReservation(Long reservationId) {
        return reservationRepository.findById(reservationId).orElse(null);
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public void removeReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    @Override
    public Reservation modifyReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    //@Scheduled(fixedRate = 50000) // 50 000 ms = 50 secondes
    public void mettreAJourEtAfficherReservations() {
        // 1. Mettre à jour les réservations antérieures au 01/01/2024
        Date dateLimite = java.sql.Date.valueOf(LocalDate.of(2024, 1, 1));        for (Reservation reservation : reservationRepository.findAll()) {
            if (reservation.getAnneeUniversitaire().after(dateLimite)) {
                reservation.setEstValide(false); // Exemple de mise à jour
                reservationRepository.save(reservation);
            }
        log.info("{} réservations antérieures au 01/01/2024 ont été mises à jour");
    }
}
}
