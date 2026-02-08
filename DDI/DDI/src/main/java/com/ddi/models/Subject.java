package com.ddi.models;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Antonio
 *
 * Clase que representa una asignatura relacion N:M con Student
 */
@Entity
public class Subject {

    /**
     * Id de la asignatura
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre de la asignatura
     */
    private String name;

    /**
     * Descripcion de la asignatura
     */
    private String description;

    /**
     * Lista de estudiantes (Relación N:M).
     * Se ignora en el JSON para evitar bucles infinitos.
     */
    @ManyToMany(mappedBy = "subjects")
    @JsonIgnore
    private Set<Student> students = new HashSet<>();

    /**
     * Constructor vacío
     */
    public Subject() {
    }

    /**
     * Constructor con los atributos de datos
     * @param name Nombre de la asignatura
     * @param description Descripción
     */
    public Subject(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}