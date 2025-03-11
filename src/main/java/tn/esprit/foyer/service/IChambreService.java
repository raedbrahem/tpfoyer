package tn.esprit.foyer.service;
import tn.esprit.foyer.entities.Chambre;
import tn.esprit.foyer.entities.TypeChambre;
import java.util.List;
public interface IChambreService {
    public List<Chambre> retrieveAllChambres();
    public Chambre retrieveChambre(Long chambreId);
    public Chambre addChambre(Chambre c);
    public void removeChambre(Long chambreId);
    public Chambre modifyChambre(Chambre chambre);

    public List<Chambre> findbytypechambre(TypeChambre typeC) ;
public Chambre findChambreByNumero(Long numeroChambre);


}
