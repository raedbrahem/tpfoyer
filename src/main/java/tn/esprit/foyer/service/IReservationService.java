package tn.esprit.foyer.service;

import tn.esprit.foyer.entities.Reservation;

import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservations();
    Reservation retrieveReservation(Long reservationId);
    Reservation addReservation(Reservation reservation);
    void removeReservation(Long reservationId);
    Reservation modifyReservation(Reservation reservation);
}
