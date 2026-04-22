package com.yomna.miniprojetevenement.restcontrollers;


import java.util.List;

import com.yomna.miniprojetevenement.entities.Evenement;
import com.yomna.miniprojetevenement.service.EvenementService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@CrossOrigin
@AllArgsConstructor
public class EvenementRESTController {

    private final EvenementService evenementService;

    @RequestMapping(path = "all", method = RequestMethod.GET)
    public List<Evenement> getAllEvenements() {
        return evenementService.getAllEvenements();
    }

    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
    public Evenement getEvenementById(@PathVariable("id") Long id) {
        return evenementService.getEvenement(id);
    }

    @RequestMapping(path = "/addeve", method = RequestMethod.POST)
    public Evenement createEvenement(@RequestBody Evenement evenement) {
        return evenementService.saveEvenement(evenement);
    }

    @RequestMapping(path = "/updateeve", method = RequestMethod.PUT)
    public Evenement updateEvenement(@RequestBody Evenement evenement) {
        return evenementService.updateEvenement(evenement);
    }

    @RequestMapping(value = "/deleve/{id}", method = RequestMethod.DELETE)
    public void deleteEvenement(@PathVariable("id") Long id) {
        evenementService.deleteEvenementById(id);
    }

    @RequestMapping(value = "/eveByName/{nom}", method = RequestMethod.GET)
    public List<Evenement> findByNomEvenement(@PathVariable("nom") String nom) {
        return evenementService.findByNomEvenementContains(nom);
    }

    @RequestMapping(value = "/evegen/{idGenre}", method = RequestMethod.GET)
    public List<Evenement> getEvenementByGenreId(@PathVariable("idGenre") Long idGenre) {
        return evenementService.findByGenreIdGenre(idGenre);
    }
}