package com.ddi.repositories;

import com.ddi.models.InstalacionDeportiva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Interface that contains the repository for InstalacionDeportiva.
 *
 * @author Antonio
 */
@Repository
public interface InstalacionRepository extends JpaRepository<InstalacionDeportiva, Long> {

    /**
     * Pre: fecha not null.
     * Post: returns the list of instalaciones that have no reserva on the given date.
     */
    @Query("SELECT i FROM InstalacionDeportiva i WHERE i.id NOT IN (SELECT r.instalacion.id FROM Reserva r WHERE r.fecha = :fecha)")
    List<InstalacionDeportiva> findInstalacionesDisponiblesPorFecha(@Param("fecha") LocalDate fecha);
}