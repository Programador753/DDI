package com.ddi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class that contains an InstalacionDeportiva.
 *
 * @author Antonio
 */
@Entity
@Table(name = "instalaciones")
public class InstalacionDeportiva {

    /**
     * Id of the instalacion.
     */
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    /**
     * Name of the instalacion.
     */
    private @Column(nullable = false) String nombre;

    /**
     * Type of the instalacion.
     */
    private @Column(nullable = false) String tipoInstalacion;

    /**
     * Location of the instalacion.
     */
    private @Column(nullable = false) String ubicacion;

    /**
     * Reservas of the instalacion.
     * Si no añadimos el ignore, se genera un bucle infinito porque el JSON
     * nunca deja de formarse.
     */
    @JsonIgnoreProperties("instalacion")
    @OneToMany(mappedBy = "instalacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reserva> reservas = new ArrayList<>();

    public InstalacionDeportiva() {}

    public InstalacionDeportiva(String nombre, String tipoInstalacion, String ubicacion) {
        this.nombre = nombre;
        this.tipoInstalacion = tipoInstalacion;
        this.ubicacion = ubicacion;
    }

    /**
     * Pre: -
     * Post: returns the id of the instalacion.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Pre: -
     * Post: returns the name of the instalacion.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Pre: -
     * Post: returns the type of the instalacion.
     */
    public String getTipoInstalacion() {
        return this.tipoInstalacion;
    }

    /**
     * Pre: -
     * Post: returns the location of the instalacion.
     */
    public String getUbicacion() {
        return this.ubicacion;
    }

    /**
     * Pre: -
     * Post: returns the list of reservas of the instalacion.
     */
    public List<Reserva> getReservas() {
        return this.reservas;
    }

    /**
     * Pre: id not null.
     * Post: the id of the instalacion is updated.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Pre: nombre not null.
     * Post: the name of the instalacion is updated.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Pre: tipoInstalacion not null.
     * Post: the type of the instalacion is updated.
     */
    public void setTipoInstalacion(String tipoInstalacion) {
        this.tipoInstalacion = tipoInstalacion;
    }

    /**
     * Pre: ubicacion not null.
     * Post: the location of the instalacion is updated.
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Pre: reservas not null.
     * Post: the list of reservas of the instalacion is updated.
     */
    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    /**
     * Pre: o is an Object.
     * Post: returns true if both instalaciones have the same id.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InstalacionDeportiva)) return false;
        InstalacionDeportiva that = (InstalacionDeportiva) o;
        return Objects.equals(this.id, that.id);
    }

    /**
     * Pre: -
     * Post: returns the hash code of the instalacion.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.nombre);
    }

    /**
     * Pre: -
     * Post: returns a string representation of the instalacion.
     */
    @Override
    public String toString() {
        return "InstalacionDeportiva{" + "id=" + this.id + ", nombre='" + this.nombre + '\'' + '}';
    }
}