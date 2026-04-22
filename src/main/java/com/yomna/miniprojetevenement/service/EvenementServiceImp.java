package com.yomna.miniprojetevenement.service;



import java.util.List;

import com.yomna.miniprojetevenement.entities.Evenement;
import com.yomna.miniprojetevenement.entities.Genre;
import com.yomna.miniprojetevenement.repos.EvenementRepository;
import com.yomna.miniprojetevenement.repos.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;


@Service
public class EvenementServiceImp implements EvenementService {

    @Autowired
    EvenementRepository evenementRepository;

    @Autowired
    GenreRepository genreRepository;

    @PreAuthorize("hasAuthority('ADMIN')")
    @Override
    public Evenement saveEvenement(Evenement e) {
        // Recharger le Genre depuis la BDD pour avoir l'entité complète
        if (e.getGenre() != null && e.getGenre().getIdGenre() != null) {
            Genre genre = genreRepository.findById(e.getGenre().getIdGenre())
                    .orElse(null);
            e.setGenre(genre);
        }
        return evenementRepository.save(e);
    }

    @Override
    public Evenement updateEvenement(Evenement e) {
        // Même fix pour l'update
        if (e.getGenre() != null && e.getGenre().getIdGenre() != null) {
            Genre genre = genreRepository.findById(e.getGenre().getIdGenre())
                    .orElse(null);
            e.setGenre(genre);
        }
        return evenementRepository.save(e);
    }

    @Override
    public void deleteEvenement(Evenement e) {
        evenementRepository.delete(e);
    }

    @Override
    public void deleteEvenementById(Long id) {
        evenementRepository.deleteById(id);
    }

    @Override
    public Evenement getEvenement(Long id) {
        return evenementRepository.findById(id).get();
    }

    @Override
    public List<Evenement> getAllEvenements() {
        return evenementRepository.findAll();
    }

    @Override
    public List<Evenement> findByNomEvenement(String nom) {
        return evenementRepository.findByNomEvenement(nom);
    }

    @Override
    public List<Evenement> findByNomEvenementContains(String nom) {
        return evenementRepository.findByNomEvenementContains(nom);
    }

    @Override
    public List<Evenement> findByGenre(Genre genre) {
        return evenementRepository.findByGenre(genre);
    }

    @Override
    public List<Evenement> findByGenreIdGenre(Long id) {
        return evenementRepository.findByGenreIdGenre(id);
    }

    @Override
    public List<Evenement> findByOrderByNomEvenementAsc() {
        return evenementRepository.findByOrderByNomEvenementAsc();
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }
}