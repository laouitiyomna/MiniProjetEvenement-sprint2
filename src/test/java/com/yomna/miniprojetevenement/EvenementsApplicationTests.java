package com.yomna.miniprojetevenement;

import java.util.Date;
import java.util.List;

import com.yomna.miniprojetevenement.entities.Evenement;
import com.yomna.miniprojetevenement.entities.Genre;
import com.yomna.miniprojetevenement.repos.EvenementRepository;
import com.yomna.miniprojetevenement.repos.GenreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
class EvenementsApplicationTests {

    @Autowired
    private EvenementRepository evenementRepository;

    @Autowired
    private GenreRepository genreRepository;

    private Genre testGenre;

    @BeforeEach
    void setup() {
        testGenre = new Genre();
        testGenre.setNomGenre("Conférence");
        testGenre = genreRepository.save(testGenre);
    }

    private Evenement createSampleEvenement(String nom) {
        Evenement evenement = new Evenement(
                nom,
                "Salle 101",
                new Date(),
                "Université Rades",
                "contact@univ-rades.tn"
        );
        evenement.setGenre(testGenre);
        return evenementRepository.save(evenement);
    }

    @Test
    public void testCreateEvenement() {
        Evenement ev = new Evenement("Conférence BDD", "Salle 101", new Date(), "Université Rades", "contact@univ-rades.tn");
        ev.setGenre(testGenre);
        evenementRepository.save(ev);
    }

    @Test
    public void testFindEvenement() {
        Evenement created = createSampleEvenement("Conférence Find");
        Evenement ev = evenementRepository.findById(created.getIdEvenement()).get();
        System.out.println(ev);
    }

    @Test
    public void testUpdateEvenement() {
        Evenement created = createSampleEvenement("Conférence Initiale");
        Evenement ev = evenementRepository.findById(created.getIdEvenement()).get();
        ev.setNomEvenement("Conférence Spring Boot");
        evenementRepository.save(ev);
        System.out.println(ev);
    }

    @Test
    public void testDeleteEvenement() {
        Evenement created = createSampleEvenement("Conférence Delete");
        evenementRepository.deleteById(created.getIdEvenement());
    }

    @Test
    public void testListerTousEvenements() {
        List<Evenement> evs = evenementRepository.findAll();
        for (Evenement ev : evs) {
            System.out.println(ev);
        }
    }

    @Test
    public void testFindByNomEvenement() {
        createSampleEvenement("Conférence Java");
        List<Evenement> events = evenementRepository.findByNomEvenement("Conférence Java");
        System.out.println("RECHERCHE EVENEMENT PAR NOM: ");
        for (Evenement ev : events)
            System.out.println(ev);
    }

    @Test
    public void testFindByNomEvenementContains() {
        createSampleEvenement("Conférence Web");
        List<Evenement> events = evenementRepository.findByNomEvenementContains("Conférence");
        System.out.println("LES NOMS DES EVENEMENTS SONT: ");
        for (Evenement ev : events)
            System.out.println(ev);
    }

    @Test
    public void testFindByNomAndLieu() {
        createSampleEvenement("Conférence a");
        List<Evenement> events = evenementRepository.findByNomAndLieu("Conférence a", "Salle 101");
        System.out.println("RECHERCHE PAR NOM ET LIEU: ");
        for (Evenement ev : events)
            System.out.println(ev);
    }

    @Test
    public void testFindByGenre() {
        createSampleEvenement("Conférence Genre");
        System.out.println("GENRE EVENEMENTS: ");
        List<Evenement> events = evenementRepository.findByGenre(testGenre);
        for (Evenement ev : events)
            System.out.println(ev);
    }

    @Test
    public void testFindByGenreId() {
        createSampleEvenement("Conférence Genre ID");
        List<Evenement> events = evenementRepository.findByGenreIdGenre(testGenre.getIdGenre());
        System.out.println("RECHERCHE PAR ID GENRE: ");
        for (Evenement ev : events)
            System.out.println(ev);
    }

    @Test
    public void testFindByOrderByNomEvenementAsc() {
        List<Evenement> evs = evenementRepository.findByOrderByNomEvenementAsc();
        System.out.println("ORDRE CROISSANT DES NOMS EVENEMENTS: ");
        for (Evenement ev : evs)
            System.out.println(ev);
    }

    @Test
    public void testTrierEvenementsNomDate() {
        List<Evenement> evs = evenementRepository.trierEvenementsNomDate();
        System.out.println("ORDRE CROISSANT NOMS / CROISSANT DATE: ");
        for (Evenement ev : evs)
            System.out.println(ev);
    }
}