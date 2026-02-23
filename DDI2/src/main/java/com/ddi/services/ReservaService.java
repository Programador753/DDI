package com.ddi.services;

import com.ddi.exceptions.ReservaNotFoundException;
import com.ddi.models.Reserva;
import com.ddi.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class that implements a Reserva Service.
 *
 * @author Antonio
 */
@Service
public class ReservaService {

    @Autowired
    private ReservaRepository repository;

    /**
     * Pre: -
     * Post: returns the list of all reservas.
     */
    public List<Reserva> getAllReservas() {
        return repository.findAll();
    }

    /**
     * Pre: newReserva not null.
     * Post: saves and returns the new reserva.
     */
    public Reserva newReserva(Reserva newReserva) {
        return repository.save(newReserva);
    }

    /**
     * Pre: id not null.
     * Post: returns the reserva with the given id, or throws ReservaNotFoundException.
     */
    public Reserva getReserva(Long id) throws ReservaNotFoundException {
        return repository.findById(id).orElseThrow(() -> new ReservaNotFoundException("Reserva with id = " + id + " not found."));
    }

    /**
     * Pre: id not null.
     * Post: deletes the reserva with the given id.
     */
    public void deleteReserva(Long id) {
        repository.deleteById(id);
    }

    /**
     * Pre: instalacionId not null.
     * Post: returns the list of reservas for the given instalacion id.
     */
    public List<Reserva> getReservasByInstalacionId(Long instalacionId) {
        return repository.findByInstalacionId(instalacionId);
    }
}