package com.ddi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Class that contains a Reserva.
 *
 * @author Antonio
 */
@Entity
@Table(name = "reservas")
public class Reserva {

    /**
     * Id of the reserva.
     */
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    /**
     * Date of the reserva.
     */
    private @Column(nullable = false) LocalDate fecha;

    /**
     * Time slot of the reserva.
     */
    private @Column(nullable = false) String franjaHoraria;

    /**
     * Instalacion associated with the reserva.
     * Si no añadimos el ignore, se genera un bucle infinito porque el JSON
     * nunca deja de formarse.
     */
    @JsonIgnoreProperties("reservas")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instalacion_id", nullable = false)
    private InstalacionDeportiva instalacion;

    /**
     * Evento associated with the reserva.
     */
    @JsonIgnoreProperties("reserva")
    @OneToOne(mappedBy = "reserva")
    private EventoDeportivo eventoAsociado;

    public Reserva() {}

    public Reserva(LocalDate fecha, String franjaHoraria) {
        this.fecha = fecha;
        this.franjaHoraria = franjaHoraria;
    }

    /**
     * Pre: -
     * Post: returns the id of the reserva.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Pre: -
     * Post: returns the date of the reserva.
     */
    public LocalDate getFecha() {
        return this.fecha;
    }

    /**
     * Pre: -
     * Post: returns the time slot of the reserva.
     */
    public String getFranjaHoraria() {
        return this.franjaHoraria;
    }

    /**
     * Pre: -
     * Post: returns the instalacion of the reserva.
     */
    public InstalacionDeportiva getInstalacion() {
        return this.instalacion;
    }

    /**
     * Pre: -
     * Post: returns the evento associated with the reserva.
     */
    public EventoDeportivo getEventoAsociado() {
        return this.eventoAsociado;
    }

    /**
     * Pre: id not null.
     * Post: the id of the reserva is updated.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Pre: fecha not null.
     * Post: the date of the reserva is updated.
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Pre: franjaHoraria not null.
     * Post: the time slot of the reserva is updated.
     */
    public void setFranjaHoraria(String franjaHoraria) {
        this.franjaHoraria = franjaHoraria;
    }

    /**
     * Pre: instalacion not null.
     * Post: the instalacion of the reserva is updated.
     */
    public void setInstalacion(InstalacionDeportiva instalacion) {
        this.instalacion = instalacion;
    }

    /**
     * Pre: eventoAsociado not null.
     * Post: the evento associated with the reserva is updated.
     */
    public void setEventoAsociado(EventoDeportivo eventoAsociado) {
        this.eventoAsociado = eventoAsociado;
    }

    /**
     * Pre: o is an Object.
     * Post: returns true if both reservas have the same id.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reserva)) return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(this.id, reserva.id);
    }

    /**
     * Pre: -
     * Post: returns the hash code of the reserva.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.fecha, this.franjaHoraria);
    }

    /**
     * Pre: -
     * Post: returns a string representation of the reserva.
     */
    @Override
    public String toString() {
        return "Reserva{" + "id=" + this.id + ", fecha=" + this.fecha + ", franjaHoraria='" + this.franjaHoraria + '\'' + '}';
    }
}