package com.ddi.repositories;

import com.ddi.models.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface that contains the repository for directores.
 *
 * @author Antonio
 */
@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {

    /**
     * Pre: peliculaId not null.
     * Post: returns the list of directores of the given pelicula.
     */
    @Query("SELECT d FROM Director d JOIN d.peliculas p WHERE p.id = :peliculaId")
    List<Director> findByPeliculaId(Long peliculaId);

    /**
     * Pre: -
     * Post: returns the list of directores that appear in more than 3 peliculas.
     */
    @Query("SELECT d FROM Director d WHERE SIZE(d.peliculas) > 3")
    List<Director> findDirectoresPopulares();

}
