package com.ddi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase que contiene pelicula.
 *
 * @author Antonio
 */
@Entity
@Table(name = "peliculas")
public class Pelicula {

    /**
     * Id de la pelicula.
     */
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    /**
     * Nombre de la pelicula.
     */
    private @Column(nullable = false) String nombre;

    /**
     * Fecha de estreno de la pelicula
     */
    private @Column(nullable = false) LocalDate fechaEstreno;

    /**
     * Puntuacion de la pelicula
     */
    private @Column(nullable = false) Integer puntuacion;

    /**
     * Comentarios de la pelicula.
     *
     */
    @JsonIgnoreProperties("pelicula")
    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comentario> comentarios = new ArrayList<>();

    /**
     * Directores de la pelicula.
     * 
     */
    @JsonIgnoreProperties("peliculas")
    @ManyToMany
    @JoinTable(
            name = "pelicula_directores",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "director_id")
    )
    private List<Director> directores = new ArrayList<>();

    public Pelicula() {}

    public Pelicula(String nombre, LocalDate fechaEstreno, Integer puntuacion) {
        this.nombre = nombre;
        this.fechaEstreno = fechaEstreno;
        this.puntuacion = puntuacion;
    }

    /**
     * Pre: -
     * Post: returns the id of the pelicula.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Pre: -
     * Post: returns the nombre of the pelicula.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Pre: -
     * Post: returns the fecha de estreno of the pelicula.
     */
    public LocalDate getFechaEstreno() {
        return this.fechaEstreno;
    }

    /**
     * Pre: -
     * Post: returns the puntuacion of the pelicula.
     */
    public Integer getPuntuacion() {
        return this.puntuacion;
    }

    /**
     * Pre: -
     * Post: returns the list of comentarios of the pelicula.
     */
    public List<Comentario> getComentarios() {
        return this.comentarios;
    }

    /**
     * Pre: -
     * Post: returns the list of directores of the pelicula.
     */
    public List<Director> getDirectores() {
        return this.directores;
    }

    /**
     * Pre: id not null.
     * Post: the id of the pelicula is updated.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Pre: nombre not null.
     * Post: the nombre of the pelicula is updated.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Pre: fechaEstreno not null.
     * Post: the fecha de estreno of the pelicula is updated.
     */
    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    /**
     * Pre: puntuacion not null.
     * Post: the puntuacion of the pelicula is updated.
     */
    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    /**
     * Pre: comentarios not null.
     * Post: the list of comentarios of the pelicula is updated.
     */
    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * Pre: directores not null.
     * Post: the list of directores of the pelicula is updated.
     */
    public void setDirectores(List<Director> directores) {
        this.directores = directores;
    }

    /**
     * Pre: o is an Object.
     * Post: returns true if both peliculas have the same id.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pelicula)) return false;
        Pelicula that = (Pelicula) o;
        return Objects.equals(this.id, that.id);
    }

    /**
     * Pre: -
     * Post: returns the hash code of the pelicula.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.nombre, this.fechaEstreno);
    }

    /**
     * Pre: -
     * Post: returns a string representation of the pelicula.
     */
    @Override
    public String toString() {
        return "Pelicula{" + "id=" + this.id + ", nombre='" + this.nombre + '\'' + ", fechaEstreno=" + this.fechaEstreno + '}';
    }
}
