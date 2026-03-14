package com.ddi.repositories;

import com.ddi.models.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface that contains the repository for comentarios.
 *
 * @author Antonio
 */
@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    /**
     * Pre: peliculaId not null.
     * Post: returns the list of comentarios of the given pelicula.
     */
    List<Comentario> findByPeliculaId(Long peliculaId);

}
