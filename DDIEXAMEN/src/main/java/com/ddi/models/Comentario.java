package com.ddi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Objects;

/**
 * Clase que contiene comentario.
 *
 * @author Antonio
 */
@Entity
@Table(name = "comentarios")
public class Comentario {

    /**
     * Id del comentario.
     */
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    /**
     * Titulo del comentario.
     */
    private @Column(nullable = false) String titulo;

    /**
     * Descripcion del comentario.
     */
    private @Column(nullable = false, length = 500) String descripcion;

    /**
     * Pelicula asociada al comentario.
     *
     */
    @JsonIgnoreProperties({"comentarios", "hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pelicula_id", nullable = false)
    private Pelicula pelicula;

    public Comentario() {}

    public Comentario(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    /**
     * Pre: -
     * Post: returns the id of the comentario.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Pre: -
     * Post: returns the titulo of the comentario.
     */
    public String getTitulo() {
        return this.titulo;
    }

    /**
     * Pre: -
     * Post: returns the descripcion of the comentario.
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /**
     * Pre: -
     * Post: returns the pelicula of the comentario.
     */
    public Pelicula getPelicula() {
        return this.pelicula;
    }

    /**
     * Pre: id not null.
     * Post: the id of the comentario is updated.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Pre: titulo not null.
     * Post: the titulo of the comentario is updated.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Pre: descripcion not null.
     * Post: the descripcion of the comentario is updated.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Pre: pelicula not null.
     * Post: the pelicula of the comentario is updated.
     */
    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    /**
     * Pre: o is an Object.
     * Post: returns true if both comentarios have the same id.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comentario)) return false;
        Comentario that = (Comentario) o;
        return Objects.equals(this.id, that.id);
    }

    /**
     * Pre: -
     * Post: returns the hash code of the comentario.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.titulo);
    }

    /**
     * Pre: -
     * Post: returns a string representation of the comentario.
     */
    @Override
    public String toString() {
        return "Comentario{" + "id=" + this.id + ", titulo='" + this.titulo + '\'' + '}';
    }
}
