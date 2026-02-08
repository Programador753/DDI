package com.ddi.services;

import com.ddi.models.Subject;
import com.ddi.models.Student;
import com.ddi.repositories.SubjectRepository;
import com.ddi.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Antonio
 *
 * Servicio que gestiona la lógica de negocio para las Asignaturas.
 * Incluye operaciones CRUD completas.
 */
@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    // --- INSERT (Create) ---

    /**
     * Crea una nueva asignatura.
     * @param subject Asignatura a guardar.
     * @return La asignatura guardada.
     */
    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    // --- GET ALL (Read) ---

    /**
     * Obtiene todas las asignaturas registradas.
     * @return Lista de asignaturas.
     */
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    // --- GET ELEMENT (Read by ID) ---

    /**
     * Obtiene una asignatura por su ID.
     * @param id Identificador de la asignatura.
     * @return Optional con la asignatura si existe.
     */
    public Optional<Subject> getSubjectById(Long id) {
        return subjectRepository.findById(id);
    }

    // --- UPDATE (Update) ---

    /**
     * Actualiza una asignatura existente.
     * @param id ID de la asignatura a modificar.
     * @param subjectDetails Nuevos datos.
     * @return La asignatura actualizada o null si no se encuentra.
     */
    public Subject updateSubject(Long id, Subject subjectDetails) {
        return subjectRepository.findById(id).map(subject -> {
            subject.setName(subjectDetails.getName());
            subject.setDescription(subjectDetails.getDescription());
            return subjectRepository.save(subject);
        }).orElse(null);
    }

    // --- DELETE (Delete) ---

    /**
     * Elimina una asignatura por su ID.
     * @param id ID de la asignatura.
     * @return true si se eliminó, false si no existía.
     */
    public boolean deleteSubject(Long id) {
        if (subjectRepository.existsById(id)) {
            subjectRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // --- Funcionalidad Extra (Relaciones) ---

    /**
     * Matricula a un estudiante en una asignatura (Relación N:M).
     * @param subjectId ID de la asignatura.
     * @param studentId ID del estudiante.
     * @return El estudiante actualizado.
     */
    public Student enrollStudent(Long subjectId, Long studentId) {
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Subject not found"));
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.addSubject(subject);
        return studentRepository.save(student);
    }
}