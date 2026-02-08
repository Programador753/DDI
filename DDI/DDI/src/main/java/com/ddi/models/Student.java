package com.ddi.models;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Antonio
 *
 * Clase que representa un Estudiante.
 * Relación N:1 con School y N:M con Subject.
 */
@Entity
public class Student {

    /**
     * Id del estudiante
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del estudiante
     */
    private String name;

    /**
     * Rol del estudiante
     */
    private String role;

    /**
     * Escuela a la que pertenece el estudiante (Relación N:1).
     * @JsonIgnore evita bucles infinitos al generar el JSON.
     */
    @ManyToOne
    @JoinColumn(name = "school_id")
    @JsonIgnore
    private School school;

    /**
     * Asignaturas del estudiante (Relación N:M).
     * Esta entidad es la propietaria de la relación (contiene el JoinTable).
     */
    @ManyToMany
    @JoinTable(
            name = "student_subjects",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private Set<Subject> subjects = new HashSet<>();

    /**
     * Constructor vacío
     */
    public Student() {
    }

    /**
     * Constructor con atributos básicos
     * @param name Nombre del estudiante
     * @param role Rol del estudiante
     */
    public Student(String name, String role) {
        this.name = name;
        this.role = role;
    }

    /**
     * Método helper para añadir asignatura y mantener consistencia en memoria
     * @param subject Asignatura a añadir
     */
    public void addSubject(Subject subject) {
        this.subjects.add(subject);
        subject.getStudents().add(this);
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}