package tn.esprit.foyer.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.foyer.entities.Etudiant;
import tn.esprit.foyer.entities.RedCrescent;
import tn.esprit.foyer.repository.RedCrescentRepository;

import java.util.List;

@Service
public class ServiceRedCrescent implements IRedCerscentservice{

    @Autowired
    RedCrescentRepository redCrescentRepository;

    @Override
    public List<RedCrescent> getAllRed() {
        return redCrescentRepository.findAll();
    }

    @Override
    public RedCrescent getbyId(Long id) {
        return redCrescentRepository.findById(id).get();
    }

    @Override
    public RedCrescent addRed(RedCrescent redCrescent) {
        return redCrescentRepository.save(redCrescent);
    }

    @Override
    public void removeRed(Long redId) {
        redCrescentRepository.deleteById(redId);

    }

    @Override
    public RedCrescent modifyRed(RedCrescent redCrescent) {
        return redCrescentRepository.save(redCrescent);
    }


}
