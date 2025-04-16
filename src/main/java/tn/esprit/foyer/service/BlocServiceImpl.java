package tn.esprit.foyer.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.foyer.entities.Bloc;
import tn.esprit.foyer.entities.Chambre;
import tn.esprit.foyer.repository.BlocRepository;

import java.util.List;
@Slf4j
@Service
@AllArgsConstructor
public class BlocServiceImpl implements IBlocService {
   @Autowired
    private  BlocRepository blocRepository;

   // @Scheduled(fixedDelay = 2000)
    @Override
    public List<Bloc> retrieveAllBlocs() {
        for (Bloc b: blocRepository.findAll()) {
            log.info("Bloc - ID: {}, Capacité: {}, Nom: {}",
                    b.getIdBloc(), b.getCapaciteBloc(), b.getNomBloc());
        }
        return blocRepository.findAll();
    }

    @Override
    public Bloc retrieveBloc(Long blocId) {
        return blocRepository.findById(blocId).orElse(null);
    }



    @Override
    public Bloc addBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public void removeBloc(Long blocId) {
        blocRepository.deleteById(blocId);
    }

    @Override
    public Bloc modifyBloc(Bloc chambre) {
        return null;
    }

}
