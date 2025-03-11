package tn.esprit.foyer.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity

public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long employeId;
    String lastName;
    String firstName;
    String position;
    @ManyToOne
    Company company;
    @OneToMany(mappedBy = "employe")
    Set<Donation> donations;
}
