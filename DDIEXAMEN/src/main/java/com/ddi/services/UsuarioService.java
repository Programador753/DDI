package com.ddi.services;

import com.ddi.exceptions.UsuarioNotFoundException;
import com.ddi.models.Usuario;
import com.ddi.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class that implements a Usuario Service.
 *
 * @author Antonio
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Pre: -
     * Post: returns the list of all usuarios.
     */
    public List<Usuario> getAllUsuarios() {
        return repository.findAll();
    }

    /**
     * Pre: newUsuario not null.
     * Post: saves the usuario with an encoded password and returns it.
     */
    public Usuario newUsuario(Usuario newUsuario) {
        newUsuario.setPassword(passwordEncoder.encode(newUsuario.getPassword()));
        return repository.save(newUsuario);
    }

    /**
     * Pre: id not null.
     * Post: returns the usuario with the given id, or throws UsuarioNotFoundException.
     */
    public Usuario getUsuario(Long id) throws UsuarioNotFoundException {
        return repository.findById(id).orElseThrow(() -> new UsuarioNotFoundException("Usuario with id = " + id + " not found."));
    }

    /**
     * Pre: newUsuario and id not null.
     * Post: replaces the usuario with the given id and returns the updated usuario.
     */
    public Usuario replaceUsuario(Usuario newUsuario, Long id) {
        return repository.findById(id)
                .map(usuario -> {
                    usuario.setNombre(newUsuario.getNombre());
                    usuario.setCorreoElectronico(newUsuario.getCorreoElectronico());
                    usuario.setPassword(newUsuario.getPassword());
                    usuario.setRole(newUsuario.getRole());
                    return repository.save(usuario);
                })
                .orElseGet(() -> repository.save(newUsuario));
    }

    /**
     * Pre: id not null.
     * Post: deletes the usuario with the given id.
     */
    public void deleteUsuario(Long id) {
        repository.deleteById(id);
    }
}