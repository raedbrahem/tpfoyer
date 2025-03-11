package tn.esprit.foyer.service;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.foyer.entities.Chambre;
import tn.esprit.foyer.entities.TypeChambre;
import tn.esprit.foyer.repository.ChambreRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChambreServiceImpl implements IChambreService {
    @Autowired
    ChambreRepository chambreRepository;
    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }
    public Chambre retrieveChambre(Long chambreId) {
        return chambreRepository.findById(chambreId).get();

    }
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }
    public void removeChambre(Long chambreId) {
        chambreRepository.deleteById(chambreId);
    }
    public Chambre modifyChambre(Chambre chambre) {

        return chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> findbytypechambre(TypeChambre typeC) {
        return chambreRepository.findAllByTypeC(typeC);
    }

    @Override
    public Chambre findChambreByNumero(Long chambreid) {
        return chambreRepository.findChambreBynumeroChambre(chambreid);
    }


}
