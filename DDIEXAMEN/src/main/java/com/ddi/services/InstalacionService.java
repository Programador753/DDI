package com.ddi.services;

import com.ddi.exceptions.InstalacionNotFoundException;
import com.ddi.models.InstalacionDeportiva;
import com.ddi.repositories.InstalacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

/**
 * Class that implements an Instalacion Service.
 *
 * @author Antonio
 */
@Service
public class InstalacionService {

    @Autowired
    private InstalacionRepository repository;

    /**
     * Pre: -
     * Post: returns the list of all instalaciones.
     */
    public List<InstalacionDeportiva> getAllInstalaciones() {
        return repository.findAll();
    }

    /**
     * Pre: newInstalacion not null.
     * Post: saves and returns the new instalacion.
     */
    public InstalacionDeportiva newInstalacion(InstalacionDeportiva newInstalacion) {
        return repository.save(newInstalacion);
    }

    /**
     * Pre: id not null.
     * Post: returns the instalacion with the given id, or throws InstalacionNotFoundException.
     */
    public InstalacionDeportiva getInstalacion(Long id) throws InstalacionNotFoundException {
        return repository.findById(id).orElseThrow(() -> new InstalacionNotFoundException("Instalacion with id = " + id + " not found."));
    }

    /**
     * Pre: id not null.
     * Post: deletes the instalacion with the given id.
     */
    public void deleteInstalacion(Long id) {
        repository.deleteById(id);
    }

    /**
     * Pre: fecha not null.
     * Post: returns the list of instalaciones available on the given date.
     */
    public List<InstalacionDeportiva> getInstalacionesDisponibles(LocalDate fecha) {
        return repository.findInstalacionesDisponiblesPorFecha(fecha);
    }
}