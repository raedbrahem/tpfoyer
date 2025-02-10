package tn.esprit.foyer.service;
import tn.esprit.foyer.entities.Bloc;
import tn.esprit.foyer.entities.Chambre;

import java.util.List;
public interface IBlocService {
    public List<Bloc> retrieveAllBlocs();
    public Bloc retrieveBloc(Long blocId);
    public Bloc addBloc(Chambre c);

    Bloc addBloc(Bloc bloc);

    public void removeBloc(Long chambreId);
    public Bloc modifyBloc(Bloc chambre);
}
