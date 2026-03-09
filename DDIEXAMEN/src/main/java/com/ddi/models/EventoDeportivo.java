package com.ddi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class that contains an EventoDeportivo.
 *
 * @author Antonio
 */
@Entity
@Table(name = "eventos")
public class EventoDeportivo {

    /**
     * Id of the evento.
     */
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    /**
     * Name of the evento.
     */
    private @Column(nullable = false) String nombre;

    /**
     * Description of the evento.
     */
    private @Column(length = 500) String descripcion;

    /**
     * Date of the evento.
     */
    private @Column(nullable = false) LocalDate fecha;

    /**
     * Time of the evento.
     */
    private @Column(nullable = false) LocalTime hora;

    /**
     * Duration of the evento in minutes.
     */
    private @Column(nullable = false) Integer duracion;

    /**
     * Participantes of the evento.
     * Si no añadimos el ignore, se genera un bucle infinito porque el JSON
     * nunca deja de formarse.
     */
    @JsonIgnoreProperties("eventos")
    @ManyToMany
    @JoinTable(
            name = "evento_participantes",
            joinColumns = @JoinColumn(name = "evento_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private List<Usuario> participantes = new ArrayList<>();

    /**
     * Reserva of the evento.
     */
    @JsonIgnoreProperties("eventoAsociado")
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reserva_id", referencedColumnName = "id")
    private Reserva reserva;

    public EventoDeportivo() {}

    public EventoDeportivo(String nombre, String descripcion, LocalDate fecha, LocalTime hora, Integer duracion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.duracion = duracion;
    }

    /**
     * Pre: -
     * Post: returns the id of the evento.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Pre: -
     * Post: returns the name of the evento.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Pre: -
     * Post: returns the description of the evento.
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * Pre: -
     * Post: returns the date of the evento.
     */
    public LocalDate getFecha() {
        return this.fecha;
    }

    /**
     * Pre: -
     * Post: returns the time of the evento.
     */
    public LocalTime getHora() {
        return this.hora;
    }

    /**
     * Pre: -
     * Post: returns the duration of the evento.
     */
    public Integer getDuracion() {
        return this.duracion;
    }

    /**
     * Pre: -
     * Post: returns the list of participantes of the evento.
     */
    public List<Usuario> getParticipantes() {
        return this.participantes;
    }

    /**
     * Pre: -
     * Post: returns the reserva of the evento.
     */
    public Reserva getReserva() {
        return this.reserva;
    }

    /**
     * Pre: id not null.
     * Post: the id of the evento is updated.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Pre: nombre not null.
     * Post: the name of the evento is updated.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Pre: descripcion not null.
     * Post: the description of the evento is updated.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Pre: fecha not null.
     * Post: the date of the evento is updated.
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Pre: hora not null.
     * Post: the time of the evento is updated.
     */
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    /**
     * Pre: duracion not null.
     * Post: the duration of the evento is updated.
     */
    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    /**
     * Pre: participantes not null.
     * Post: the list of participantes of the evento is updated.
     */
    public void setParticipantes(List<Usuario> participantes) {
        this.participantes = participantes;
    }

    /**
     * Pre: reserva not null.
     * Post: the reserva of the evento is updated.
     */
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    /**
     * Pre: o is an Object.
     * Post: returns true if both eventos have the same id.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventoDeportivo)) return false;
        EventoDeportivo that = (EventoDeportivo) o;
        return Objects.equals(this.id, that.id);
    }

    /**
     * Pre: -
     * Post: returns the hash code of the evento.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.nombre, this.fecha);
    }

    /**
     * Pre: -
     * Post: returns a string representation of the evento.
     */
    @Override
    public String toString() {
        return "EventoDeportivo{" + "id=" + this.id + ", nombre='" + this.nombre + '\'' + ", fecha=" + this.fecha + '}';
    }
}