package com.ddi.controllers;

import com.ddi.exceptions.InstalacionNotFoundException;
import com.ddi.models.InstalacionDeportiva;
import com.ddi.services.InstalacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Class that implements an Instalacion Controller.
 *
 * @author Antonio
 */
@RestController
public class InstalacionController {

    @Autowired
    private InstalacionService instalacionService;

    /**
     * Pre: -
     * Post: returns the list of all instalaciones.
     */
    @GetMapping("/instalaciones")
    public List<InstalacionDeportiva> getAllInstalaciones() {
        return instalacionService.getAllInstalaciones();
    }

    /**
     * Pre: json not null.
     * Post: creates and returns the new instalacion.
     */
    @PostMapping("/instalaciones")
    public InstalacionDeportiva newInstalacion(@RequestBody InstalacionDeportiva json) {
        return instalacionService.newInstalacion(json);
    }

    /**
     * Pre: id not null.
     * Post: returns the instalacion with the given id, or throws InstalacionNotFoundException.
     */
    @GetMapping("/instalaciones/{id}")
    public InstalacionDeportiva getInstalacion(@PathVariable Long id) throws InstalacionNotFoundException {
        return instalacionService.getInstalacion(id);
    }

    /**
     * Pre: id not null.
     * Post: deletes the instalacion with the given id.
     */
    @DeleteMapping("/instalaciones/{id}")
    public void deleteInstalacion(@PathVariable Long id) {
        instalacionService.deleteInstalacion(id);
    }

    /**
     * Pre: fecha not null.
     * Post: returns the list of instalaciones available on the given date.
     */
    @GetMapping("/instalaciones/disponibles/{fecha}")
    public List<InstalacionDeportiva> getInstalacionesDisponibles(@PathVariable LocalDate fecha) {
        return instalacionService.getInstalacionesDisponibles(fecha);
    }
}