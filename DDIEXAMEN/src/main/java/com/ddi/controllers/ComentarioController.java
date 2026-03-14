package com.ddi.controllers;

import com.ddi.models.Comentario;
import com.ddi.services.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase que implementa el controlador de Comentarios.
 *
 * @author Antonio
 */
@RestController
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    /**
     * Pre: -
     * Post: returns the list of all comentarios.
     */
    @GetMapping("/comentarios")
    public List<Comentario> getAllComentarios() {
        return comentarioService.getAllComentarios();
    }

    /**
     * Pre: id not null.
     * Post: returns the list of comentarios of the pelicula with the given id.
     */
    @GetMapping("/comentarios/{id}")
    public List<Comentario> getComentariosByPelicula(@PathVariable Long id) {
        return comentarioService.getComentariosByPelicula(id);
    }

    /**
     * Pre: id and json not null.
     * Post: creates a new comentario associated to the pelicula with the given id.
     */
    @PostMapping("/comentarios/{id}")
    public Comentario newComentario(@PathVariable Long id, @RequestBody Comentario json) {
        return comentarioService.newComentario(id, json);
    }

}
