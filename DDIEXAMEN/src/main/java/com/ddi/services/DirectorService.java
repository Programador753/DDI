package com.ddi.services;

import com.ddi.models.Director;
import com.ddi.models.Pelicula;
import com.ddi.repositories.DirectorRepository;
import com.ddi.repositories.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class that implements a Director Service.
 *
 * @author Antonio
 */
@Service
public class DirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private PeliculaRepository peliculaRepository;

    /**
     * Pre: -
     * Post: returns the list of all directores.
     */
    public List<Director> getAllDirectores() {
        return directorRepository.findAll();
    }

    /**
     * Pre: peliculaId not null.
     * Post: returns the list of directores of the given pelicula.
     */
    public List<Director> getDirectoresByPelicula(Long peliculaId) {
        return directorRepository.findByPeliculaId(peliculaId);
    }

    /**
     * Pre: peliculaId and director not null.
     * Post: adds a new director to the pelicula with the given id.
     */
    public Director addDirectorToPelicula(Long peliculaId, Director director) {
        Pelicula pelicula = peliculaRepository.findById(peliculaId).orElse(null);
        if (pelicula == null) {
            return null;
        }
        Director savedDirector = directorRepository.save(director);
        pelicula.getDirectores().add(savedDirector);
        peliculaRepository.save(pelicula);
        return savedDirector;
    }

    /**
     * Pre: -
     * Post: returns the list of directores that appear in more than 3 peliculas.
     */
    public List<Director> getDirectoresPopulares() {
        return directorRepository.findDirectoresPopulares();
    }

}
