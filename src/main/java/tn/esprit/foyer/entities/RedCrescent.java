package tn.esprit.foyer.entities;


import jakarta.persistence.*;

import java.util.Set;

@Entity
public class RedCrescent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long redCID;
    String area;
    @OneToMany
    Set<Donation> donations;

    public RedCrescent(long redCID, String area, Set<Donation> donations) {
        this.redCID = redCID;
        this.area = area;
        this.donations = donations;
    }

    public RedCrescent() {
    }

    public long getRedCID() {
        return redCID;
    }

    public String getArea() {
        return area;
    }

    public Set<Donation> getDonations() {
        return donations;
    }

    public void setRedCID(long redCID) {
        this.redCID = redCID;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setDonations(Set<Donation> donations) {
        this.donations = donations;
    }
}
