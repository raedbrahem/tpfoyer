package tn.esprit.foyer.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtudiant;
    private String nomEt;
    private String prenomEt;
    private Long cin;
    private String ecole;
    private LocalDate dateNaissance;

    @ManyToMany(mappedBy = "etudiants")
    private List<Reservation> reservations;

    public Etudiant(Long idEtudiant, String nomEt, String prenomEt, Long cin, String ecole, LocalDate  dateNaissance, List<Reservation> reservations) {
        this.idEtudiant = idEtudiant;
        this.nomEt = nomEt;
        this.prenomEt = prenomEt;
        this.cin = cin;
        this.ecole = ecole;
        this.dateNaissance = dateNaissance;
        this.reservations = reservations;
    }

    public Long getIdEtudiant() {
        return idEtudiant;
    }

    public String getNomEt() {
        return nomEt;
    }

    public String getPrenomEt() {
        return prenomEt;
    }

    public Long getCin() {
        return cin;
    }

    public String getEcole() {
        return ecole;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setIdEtudiant(Long idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public void setNomEt(String nomEt) {
        this.nomEt = nomEt;
    }

    public void setPrenomEt(String prenomEt) {
        this.prenomEt = prenomEt;
    }

    public void setCin(Long cin) {
        this.cin = cin;
    }

    public void setEcole(String ecole) {
        this.ecole = ecole;
    }

    public void setDateNaissance(LocalDate  dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Etudiant() {
    }
}