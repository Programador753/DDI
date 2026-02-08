package com.ddi.controllers;

import com.ddi.models.Subject;
import com.ddi.models.Student;
import com.ddi.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Antonio
 *
 * Controlador REST para gestionar peticiones sobre Asignaturas.
 * Soporta operaciones CRUD completas.
 */
@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    // --- INSERT Elemento ---
    @PostMapping
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
        return ResponseEntity.ok(subjectService.createSubject(subject));
    }

    // --- GET All Elementos ---
    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    // --- GET Elemento (ID) ---
    @GetMapping("/{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable Long id) {
        Optional<Subject> subject = subjectService.getSubjectById(id);
        return subject.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // --- UPDATE Elemento ---
    @PutMapping("/{id}")
    public ResponseEntity<Subject> updateSubject(@PathVariable Long id, @RequestBody Subject subjectDetails) {
        Subject updatedSubject = subjectService.updateSubject(id, subjectDetails);
        if (updatedSubject != null) {
            return ResponseEntity.ok(updatedSubject);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // --- DELETE Elemento ---
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable Long id) {
        if (subjectService.deleteSubject(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // --- EXTRA: Matricular (Relación N:M) ---
    @PostMapping("/{subjectId}/enroll/{studentId}")
    public ResponseEntity<Student> enrollStudent(@PathVariable Long subjectId, @PathVariable Long studentId) {
        try {
            return ResponseEntity.ok(subjectService.enrollStudent(subjectId, studentId));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}