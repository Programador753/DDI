package com.ddi.controllers;

import com.ddi.exceptions.EventoNotFoundException;
import com.ddi.models.EventoDeportivo;
import com.ddi.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Class that implements an Evento Controller.
 *
 * @author Antonio
 */
@RestController
public class EventoController {

    @Autowired
    private EventoService eventoService;

    /**
     * Pre: -
     * Post: returns the list of all eventos.
     */
    @GetMapping("/eventos")
    public List<EventoDeportivo> getAllEventos() {
        return eventoService.getAllEventos();
    }

    /**
     * Pre: json not null.
     * Post: creates and returns the new evento.
     */
    @PostMapping("/eventos")
    public EventoDeportivo newEvento(@RequestBody EventoDeportivo json) {
        return eventoService.newEvento(json);
    }

    /**
     * Pre: id not null.
     * Post: returns the evento with the given id, or throws EventoNotFoundException.
     */
    @GetMapping("/eventos/{id}")
    public EventoDeportivo getEvento(@PathVariable Long id) throws EventoNotFoundException {
        return eventoService.getEvento(id);
    }

    /**
     * Pre: newEvento and id not null.
     * Post: replaces the evento with the given id and returns the updated evento.
     */
    @PutMapping("/eventos/{id}")
    public EventoDeportivo replaceEvento(@RequestBody EventoDeportivo newEvento, @PathVariable Long id) {
        return eventoService.replaceEvento(newEvento, id);
    }

    /**
     * Pre: id not null.
     * Post: deletes the evento with the given id.
     */
    @DeleteMapping("/eventos/{id}")
    public void deleteEvento(@PathVariable Long id) {
        eventoService.deleteEvento(id);
    }

    /**
     * Pre: fecha not null.
     * Post: returns the list of eventos on the given date.
     */
    @GetMapping("/eventos/fecha/{fecha}")
    public List<EventoDeportivo> getEventosByFecha(@PathVariable LocalDate fecha) {
        return eventoService.getEventosByFecha(fecha);
    }

    /**
     * Pre: ubicacion not null.
     * Post: returns the list of eventos in the given location.
     */
    @GetMapping("/eventos/ubicacion/{ubicacion}")
    public List<EventoDeportivo> getEventosByUbicacion(@PathVariable String ubicacion) {
        return eventoService.getEventosByUbicacion(ubicacion);
    }
}