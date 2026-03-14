package com.ddi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase que contiene director.
 *
 * @author Antonio
 */
@Entity
@Table(name = "directores")
public class Director {

    /**
     * Id del director.
     */
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    /**
     * Nombre del director.
     */
    private @Column(nullable = false) String nombre;

    /**
     * Apellido del director.
     */
    private @Column(nullable = false) String apellido;

    /**
     * Fecha de nacimiento del director.
     */
    private @Column(nullable = false) LocalDate fechaNacimiento;

    /**
     * Peliculas del director.
     *
     */
    @JsonIgnoreProperties("directores")
    @ManyToMany(mappedBy = "directores")
    private List<Pelicula> peliculas = new ArrayList<>();

    public Director() {}

    public Director(String nombre, String apellido, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Pre: -
     * Post: returns the id of the director.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Pre: -
     * Post: returns the nombre of the director.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Pre: -
     * Post: returns the apellido of the director.
     */
    public String getApellido() {
        return this.apellido;
    }

    /**
     * Pre: -
     * Post: returns the fecha de nacimiento of the director.
     */
    public LocalDate getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    /**
     * Pre: -
     * Post: returns the list of peliculas of the director.
     */
    public List<Pelicula> getPeliculas() {
        return this.peliculas;
    }

    /**
     * Pre: id not null.
     * Post: the id of the director is updated.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Pre: nombre not null.
     * Post: the nombre of the director is updated.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Pre: apellido not null.
     * Post: the apellido of the director is updated.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Pre: fechaNacimiento not null.
     * Post: the fecha de nacimiento of the director is updated.
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Pre: peliculas not null.
     * Post: the list of peliculas of the director is updated.
     */
    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    /**
     * Pre: o is an Object.
     * Post: returns true if both directores have the same id.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Director)) return false;
        Director that = (Director) o;
        return Objects.equals(this.id, that.id);
    }

    /**
     * Pre: -
     * Post: returns the hash code of the director.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.nombre, this.apellido);
    }

    /**
     * Pre: -
     * Post: returns a string representation of the director.
     */
    @Override
    public String toString() {
        return "Director{" + "id=" + this.id + ", nombre='" + this.nombre + '\'' + ", apellido='" + this.apellido + '\'' + '}';
    }
}
