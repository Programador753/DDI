package com.ddi.repositories;

import com.ddi.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interface that contains the repository for Usuario.
 *
 * @author Antonio
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Pre: correoElectronico not null.
     * Post: returns the usuario with the given email, or empty if not found.
     */
    Optional<Usuario> findByCorreoElectronico(String correoElectronico);
}