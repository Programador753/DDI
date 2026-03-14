package com.ddi.services;

import com.ddi.models.Comentario;
import com.ddi.models.Pelicula;
import com.ddi.repositories.ComentarioRepository;
import com.ddi.repositories.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class that implements a Comentario Service.
 *
 * @author Antonio
 */
@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private PeliculaRepository peliculaRepository;

    /**
     * Pre: -
     * Post: returns the list of all comentarios.
     */
    public List<Comentario> getAllComentarios() {
        return comentarioRepository.findAll();
    }

    /**
     * Pre: peliculaId not null.
     * Post: returns the list of comentarios of the given pelicula.
     */
    public List<Comentario> getComentariosByPelicula(Long peliculaId) {
        return comentarioRepository.findByPeliculaId(peliculaId);
    }

    /**
     * Pre: peliculaId and comentario not null.
     * Post: creates a new comentario associated to the pelicula with the given id.
     */
    public Comentario newComentario(Long peliculaId, Comentario comentario) {
        Pelicula pelicula = peliculaRepository.findById(peliculaId).orElse(null);
        if (pelicula == null) {
            return null;
        }
        comentario.setPelicula(pelicula);
        return comentarioRepository.save(comentario);
    }

}
