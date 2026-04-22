package com.yomna.miniprojetevenement.service;


import com.yomna.miniprojetevenement.entities.Evenement;
import com.yomna.miniprojetevenement.entities.Genre;

import java.util.List;


public interface EvenementService {
    Evenement saveEvenement(Evenement e);
    Evenement updateEvenement(Evenement e);
    void deleteEvenement(Evenement e);
    void deleteEvenementById(Long id);
    Evenement getEvenement(Long id);
    List<Evenement> getAllEvenements();
    List<Evenement> findByNomEvenement(String nom);
    List<Evenement> findByNomEvenementContains(String nom);
    List<Evenement> findByGenre(Genre genre);
    List<Evenement> findByGenreIdGenre(Long id);
    List<Evenement> findByOrderByNomEvenementAsc();
    List<Genre> getAllGenres();
}