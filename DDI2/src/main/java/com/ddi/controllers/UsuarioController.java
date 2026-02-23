package com.ddi.controllers;

import com.ddi.exceptions.UsuarioNotFoundException;
import com.ddi.models.Usuario;
import com.ddi.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class that implements a Usuario Controller.
 *
 * @author Antonio
 */
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    /**
     * Pre: -
     * Post: returns the list of all usuarios.
     */
    @GetMapping("/usuarios")
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    /**
     * Pre: json not null.
     * Post: creates and returns the new usuario.
     */
    @PostMapping("/usuarios")
    public Usuario newUsuario(@RequestBody Usuario json) {
        return usuarioService.newUsuario(json);
    }

    /**
     * Pre: id not null.
     * Post: returns the usuario with the given id, or throws UsuarioNotFoundException.
     */
    @GetMapping("/usuarios/{id}")
    public Usuario getUsuario(@PathVariable Long id) throws UsuarioNotFoundException {
        return usuarioService.getUsuario(id);
    }

    /**
     * Pre: newUsuario and id not null.
     * Post: replaces the usuario with the given id and returns the updated usuario.
     */
    @PutMapping("/usuarios/{id}")
    public Usuario replaceUsuario(@RequestBody Usuario newUsuario, @PathVariable Long id) {
        return usuarioService.replaceUsuario(newUsuario, id);
    }

    /**
     * Pre: id not null.
     * Post: deletes the usuario with the given id.
     */
    @DeleteMapping("/usuarios/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
    }
}