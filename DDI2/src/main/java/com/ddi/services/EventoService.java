package com.ddi.services;

import com.ddi.exceptions.EventoNotFoundException;
import com.ddi.models.EventoDeportivo;
import com.ddi.repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Class that implements an Evento Service.
 *
 * @author Antonio
 */
@Service
public class EventoService {

    @Autowired
    private EventoRepository repository;

    /**
     * Pre: -
     * Post: returns the list of all eventos.
     */
    public List<EventoDeportivo> getAllEventos() {
        return repository.findAll();
    }

    /**
     * Pre: newEvento not null.
     * Post: saves and returns the new evento.
     */
    public EventoDeportivo newEvento(EventoDeportivo newEvento) {
        return repository.save(newEvento);
    }

    /**
     * Pre: id not null.
     * Post: returns the evento with the given id, or throws EventoNotFoundException.
     */
    public EventoDeportivo getEvento(Long id) throws EventoNotFoundException {
        return repository.findById(id).orElseThrow(() -> new EventoNotFoundException("Evento with id = " + id + " not found."));
    }

    /**
     * Pre: newEvento and id not null.
     * Post: replaces the evento with the given id and returns the updated evento.
     */
    public EventoDeportivo replaceEvento(EventoDeportivo newEvento, Long id) {
        return repository.findById(id)
                .map(evento -> {
                    evento.setNombre(newEvento.getNombre());
                    evento.setDescripcion(newEvento.getDescripcion());
                    evento.setFecha(newEvento.getFecha());
                    evento.setHora(newEvento.getHora());
                    evento.setDuracion(newEvento.getDuracion());
                    return repository.save(evento);
                })
                .orElseGet(() -> repository.save(newEvento));
    }

    /**
     * Pre: id not null.
     * Post: deletes the evento with the given id.
     */
    public void deleteEvento(Long id) {
        repository.deleteById(id);
    }

    /**
     * Pre: fecha not null.
     * Post: returns the list of eventos on the given date.
     */
    public List<EventoDeportivo> getEventosByFecha(LocalDate fecha) {
        return repository.findByFecha(fecha);
    }

    /**
     * Pre: ubicacion not null.
     * Post: returns the list of eventos in the given location.
     */
    public List<EventoDeportivo> getEventosByUbicacion(String ubicacion) {
        return repository.findByUbicacionInstalacion(ubicacion);
    }
}