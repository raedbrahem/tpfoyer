package tn.esprit.foyer.controller;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.foyer.entities.Etudiant;
import tn.esprit.foyer.entities.RedCrescent;
import tn.esprit.foyer.service.IRedCerscentservice;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/red")
public class RedCrescentController {
    @Autowired
    IRedCerscentservice redCerscentservice;


    @GetMapping("/getAll")
    public List<RedCrescent> getAll() {
        return redCerscentservice.getAllRed();
    }
    @GetMapping("/getbyid/{red-id}")
    public RedCrescent getById(@PathVariable("red-id") Long redId) {
        return redCerscentservice.getbyId(redId);
    }
    @PostMapping("/add-red")
    public RedCrescent addRed(@RequestBody RedCrescent r)
    {
        return redCerscentservice.addRed(r);
    }
    @DeleteMapping("/remove-red/{red-id}")
    public void removeRed(@PathVariable("red-id") Long redId) {
       redCerscentservice.removeRed(redId);
    }
    @PutMapping("/modify-red")
    public RedCrescent modifyRed(@RequestBody RedCrescent e) {
        return redCerscentservice.modifyRed(e);
    }

}
