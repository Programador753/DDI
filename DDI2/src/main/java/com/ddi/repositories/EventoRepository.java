package com.ddi.repositories;

import com.ddi.models.EventoDeportivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Interface that contains the repository for EventoDeportivo.
 *
 * @author Antonio
 */
@Repository
public interface EventoRepository extends JpaRepository<EventoDeportivo, Long> {

    /**
     * Pre: fecha not null.
     * Post: returns the list of eventos on the given date.
     */
    List<EventoDeportivo> findByFecha(LocalDate fecha);

    /**
     * Pre: ubicacion not null.
     * Post: returns the list of eventos whose reserva instalacion matches the given location.
     */
    @Query("SELECT e FROM EventoDeportivo e WHERE e.reserva.instalacion.ubicacion = :ubicacion")
    List<EventoDeportivo> findByUbicacionInstalacion(@Param("ubicacion") String ubicacion);
}