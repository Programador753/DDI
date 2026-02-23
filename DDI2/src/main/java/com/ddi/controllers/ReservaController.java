package com.ddi.controllers;

import com.ddi.exceptions.ReservaNotFoundException;
import com.ddi.exceptions.InstalacionNotFoundException;
import com.ddi.models.Reserva;
import com.ddi.requestObjects.RequestReserva;
import com.ddi.services.ReservaService;
import com.ddi.services.InstalacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class that implements a Reserva Controller.
 *
 * @author Antonio
 */
@RestController
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private InstalacionService instalacionService;

    /**
     * Pre: -
     * Post: returns the list of all reservas.
     */
    @GetMapping("/reservas")
    public List<Reserva> getAllReservas() {
        return reservaService.getAllReservas();
    }

    /**
     * Pre: json not null and instalacion_id exists.
     * Post: creates and returns the new reserva linked to its instalacion.
     */
    @PostMapping("/reservas")
    public Reserva newReserva(@RequestBody RequestReserva json) throws InstalacionNotFoundException {
        json.getReserva().setInstalacion(instalacionService.getInstalacion(json.getInstalacionId()));
        return reservaService.newReserva(json.getReserva());
    }

    /**
     * Pre: id not null.
     * Post: returns the reserva with the given id, or throws ReservaNotFoundException.
     */
    @GetMapping("/reservas/{id}")
    public Reserva getReserva(@PathVariable Long id) throws ReservaNotFoundException {
        return reservaService.getReserva(id);
    }

    /**
     * Pre: instalacionId not null.
     * Post: returns the list of reservas for the given instalacion id.
     */
    @GetMapping("/instalaciones/{instalacionId}/reservas")
    public List<Reserva> getReservasByInstalacion(@PathVariable Long instalacionId) {
        return reservaService.getReservasByInstalacionId(instalacionId);
    }

    /**
     * Pre: id not null.
     * Post: deletes the reserva with the given id.
     */
    @DeleteMapping("/reservas/{id}")
    public void deleteReserva(@PathVariable Long id) {
        reservaService.deleteReserva(id);
    }
}