package tn.esprit.foyer.entities;


import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity

public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long campanyId;
        String campanyName;
        String address;
        @OneToMany(mappedBy = "company")
        Set<Employe> employes;
}
