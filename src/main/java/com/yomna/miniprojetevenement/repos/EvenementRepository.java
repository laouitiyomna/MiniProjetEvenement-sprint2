package com.yomna.miniprojetevenement.repos;


import java.util.List;

import com.yomna.miniprojetevenement.entities.Evenement;
import com.yomna.miniprojetevenement.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface EvenementRepository extends JpaRepository<Evenement, Long> {

    List<Evenement> findByNomEvenement(String nom);

    List<Evenement> findByNomEvenementContains(String nom);

    List<Evenement> findByNomEvenementAndLieu(String nomEvenement, String lieu);

    @Query("select e from Evenement e where e.nomEvenement = ?1 and e.lieu = ?2")
    List<Evenement> findByNomAndLieu(String nom, String lieu);

    @Query("select e from Evenement e where e.genre = ?1")
    List<Evenement> findByGenre(Genre genre);

    List<Evenement> findByGenreIdGenre(Long id);

    List<Evenement> findByOrderByNomEvenementAsc();

    @Query("select e from Evenement e order by e.nomEvenement asc, e.dateEvenement asc")
    List<Evenement> trierEvenementsNomDate();
}
