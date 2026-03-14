package com.ddi.controllers;

import com.ddi.models.Director;
import com.ddi.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase que implementa el controlador de Directores.
 *
 * @author Antonio
 */
@RestController
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    /**
     * Pre: -
     * Post: returns the list of all directores.
     */
    @GetMapping("/directores")
    public List<Director> getAllDirectores() {
        return directorService.getAllDirectores();
    }

    /**
     * Pre: id not null.
     * Post: returns the list of directores of the pelicula with the given id.
     */
    @GetMapping("/directores/{id}")
    public List<Director> getDirectoresByPelicula(@PathVariable Long id) {
        return directorService.getDirectoresByPelicula(id);
    }

    /**
     * Pre: id and json not null.
     * Post: adds a new director to the pelicula with the given id.
     */
    @PostMapping("/directores/{id}")
    public Director addDirectorToPelicula(@PathVariable Long id, @RequestBody Director json) {
        return directorService.addDirectorToPelicula(id, json);
    }

    /**
     * Pre: -
     * Post: returns the list of directores that appear in more than 3 peliculas.
     */
    @GetMapping("/directores/populares")
    public List<Director> getDirectoresPopulares() {
        return directorService.getDirectoresPopulares();
    }

}
