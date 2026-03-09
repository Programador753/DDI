package com.ddi.repositories;

import com.ddi.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface that contains the repository for Reserva.
 *
 * @author Antonio
 */
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    /**
     * Pre: instalacionId not null.
     * Post: returns the list of reservas associated with the given instalacion id.
     */
    List<Reserva> findByInstalacionId(Long instalacionId);
}