package com.ddi.models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio
 *
 * Clase que representa una Escuela (Relación 1:N con Student)
 */
@Entity
public class School {

    /**
     * Id de la escuela
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre de la escuela
     */
    private String name;

    /**
     * Lista de estudiantes matriculados (Relación 1:N).
     * mappedBy indica que el atributo 'school' en la clase Student gestiona la relación.
     */
    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students = new ArrayList<>();

    /**
     * Constructor vacío
     */
    public School() {
    }

    /**
     * Constructor con atributos
     * @param name Nombre de la escuela
     */
    public School(String name) {
        this.name = name;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}