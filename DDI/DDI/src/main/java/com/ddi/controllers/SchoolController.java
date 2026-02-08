package com.ddi.controllers;

import com.ddi.models.School;
import com.ddi.models.Student;
import com.ddi.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Antonio
 *
 * Controlador REST para gestionar peticiones sobre Escuelas.
 * Soporta operaciones CRUD completas.
 */
@RestController
@RequestMapping("/schools")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    // --- INSERT Elemento ---
    @PostMapping
    public ResponseEntity<School> createSchool(@RequestBody School school) {
        return ResponseEntity.ok(schoolService.createSchool(school));
    }

    // --- GET All Elementos ---
    @GetMapping
    public List<School> getAllSchools() {
        return schoolService.getAllSchools();
    }

    // --- GET Elemento (ID) ---
    @GetMapping("/{id}")
    public ResponseEntity<School> getSchool(@PathVariable Long id) {
        Optional<School> school = schoolService.getSchoolById(id);
        return school.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // --- UPDATE Elemento ---
    @PutMapping("/{id}")
    public ResponseEntity<School> updateSchool(@PathVariable Long id, @RequestBody School schoolDetails) {
        School updatedSchool = schoolService.updateSchool(id, schoolDetails);
        if (updatedSchool != null) {
            return ResponseEntity.ok(updatedSchool);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // --- DELETE Elemento ---
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchool(@PathVariable Long id) {
        if (schoolService.deleteSchool(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // --- EXTRA: Añadir estudiante a escuela (Relación 1:N) ---
    @PostMapping("/{schoolId}/students")
    public ResponseEntity<Student> addStudentToSchool(@PathVariable Long schoolId, @RequestBody Student student) {
        try {
            return ResponseEntity.ok(schoolService.addStudentToSchool(schoolId, student));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}