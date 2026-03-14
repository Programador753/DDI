package com.ddi.controllers;

import com.ddi.models.Pelicula;
import com.ddi.services.PeliculaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase que implementa el controlador de Películas.
 *
 * @author Antonio
 */
@RestController
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    /**
     * Pre: -
     * Post: returns the list of all peliculas.
     */
    @SecurityRequirement(name = "BearerAuth")
    @GetMapping("/peliculas")
    public List<Pelicula> getAllPeliculas() {
        return peliculaService.getAllPeliculas();
    }

    /**
     * Pre: json not null.
     * Post: creates and returns the new pelicula.
     */
    @SecurityRequirement(name = "BearerAuth")
    @PostMapping("/peliculas")
    public Pelicula newPelicula(@RequestBody Pelicula json) {
        return peliculaService.newPelicula(json);
    }

    /**
     * Pre: id not null.
     * Post: returns the pelicula with the given id.
     */
    @GetMapping("/peliculas/{id}")
    public Pelicula getPelicula(@PathVariable Long id) {
        return peliculaService.getPelicula(id);
    }

    /**
     * Pre: newPelicula and id not null.
     * Post: replaces the pelicula with the given id and returns the updated pelicula.
     */
    @PutMapping("/peliculas/{id}")
    public Pelicula replacePelicula(@RequestBody Pelicula newPelicula, @PathVariable Long id) {
        return peliculaService.replacePelicula(newPelicula, id);
    }

    /**
     * Pre: id not null.
     * Post: deletes the pelicula with the given id.
     */
    @DeleteMapping("/peliculas/{id}")
    public void deletePelicula(@PathVariable Long id) {
        peliculaService.deletePelicula(id);
    }

    /**
     * Pre: -
     * Post: returns the list of peliculas that have at least 2 comentarios.
     */
    @GetMapping("/peliculas/valoradas")
    public List<Pelicula> getPeliculasValoradas() {
        return peliculaService.getPeliculasValoradas();
    }

}
