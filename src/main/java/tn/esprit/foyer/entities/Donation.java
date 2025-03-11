package tn.esprit.foyer.entities;

import jakarta.persistence.*;

import java.util.Date;


@Entity
public class Donation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long donid;
    float amount;
    Date date;
    DonationType type;
    @ManyToOne
    Employe employe;
}
