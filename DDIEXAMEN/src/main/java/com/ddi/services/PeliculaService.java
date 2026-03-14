package com.ddi.services;

import com.ddi.models.Pelicula;
import com.ddi.repositories.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class that implements an Pelicula Service.
 *
 * @author Antonio
 */
@Service
public class PeliculaService {
    @Autowired
    private PeliculaRepository repository;

    /**
     * Pre: -
     * Post: returns the list of all films.
     */
    public List<Pelicula> getAllPeliculas() {
        return repository.findAll();
    }

    /**
     * Pre: newPelicula not null.
     * Post: saves and returns the new pelicula.
     */
    public Pelicula newPelicula(Pelicula newPelicula) {
        return repository.save(newPelicula);
    }

    /**
     * Pre: id not null.
     * Post: returns the pelicula with the given id, or null if not found.
     */
    public Pelicula getPelicula(Long id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Pre: newPelicula and id not null.
     * Post: replaces the pelicula with the given id and returns the updated pelicula.
     */
    public Pelicula replacePelicula(Pelicula newPelicula, Long id) {
        return repository.findById(id)
                .map(pelicula -> {
                    pelicula.setNombre(newPelicula.getNombre());
                    pelicula.setFechaEstreno(newPelicula.getFechaEstreno());
                    pelicula.setPuntuacion(newPelicula.getPuntuacion());
                    return repository.save(pelicula);
                })
                .orElseGet(() -> repository.save(newPelicula));
    }

    /**
     * Pre: id not null.
     * Post: deletes the pelicula with the given id.
     */
    public void deletePelicula(Long id) {
        repository.deleteById(id);
    }

    /**
     * Pre: -
     * Post: returns the list of peliculas that have at least 2 comentarios.
     */
    public List<Pelicula> getPeliculasValoradas() {
        return repository.findPeliculasValoradas();
    }

}
