package com.ddi.repositories;

import com.ddi.models.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface that contains the repository for peliculas.
 *
 * @author Antonio
 */
@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

    /**
     * Pre: -
     * Post: returns the list of peliculas that have at least 2 comentarios.
     */
    @Query("SELECT p FROM Pelicula p WHERE SIZE(p.comentarios) >= 2")
    List<Pelicula> findPeliculasValoradas();

}
