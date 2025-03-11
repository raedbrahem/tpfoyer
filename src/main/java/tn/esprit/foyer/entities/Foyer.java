package tn.esprit.foyer.entities;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;
@Entity
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;
    private String nomFoyer;
    private Long capaciteFoyer;
    @OneToOne
    private Universite universite;
    @OneToMany(mappedBy = "foyer")
    private List<Bloc> blocs;

    public Foyer(Long idFoyer, String nomFoyer, Long capaciteFoyer, Universite universite, List<Bloc> blocs) {
        this.idFoyer = idFoyer;
        this.nomFoyer = nomFoyer;
        this.capaciteFoyer = capaciteFoyer;
        this.universite = universite;
        this.blocs = blocs;
    }

    public Foyer() {
    }

    public Long getIdFoyer() {
        return idFoyer;
    }

    public String getNomFoyer() {
        return nomFoyer;
    }

    public Long getCapaciteFoyer() {
        return capaciteFoyer;
    }

    public Universite getUniversite() {
        return universite;
    }

    public List<Bloc> getBlocs() {
        return blocs;
    }

    public void setIdFoyer(Long idFoyer) {
        this.idFoyer = idFoyer;
    }

    public void setNomFoyer(String nomFoyer) {
        this.nomFoyer = nomFoyer;
    }

    public void setCapaciteFoyer(Long capaciteFoyer) {
        this.capaciteFoyer = capaciteFoyer;
    }

    public void setUniversite(Universite universite) {
        this.universite = universite;
    }

    public void setBlocs(List<Bloc> blocs) {
        this.blocs = blocs;
    }
}
