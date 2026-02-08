package com.ddi.services;

import com.ddi.models.School;
import com.ddi.models.Student;
import com.ddi.repositories.SchoolRepository;
import com.ddi.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Antonio
 *
 * Servicio que gestiona la lógica de negocio para las Escuelas.
 * Incluye operaciones CRUD completas.
 */
@Service
public class SchoolService {

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private StudentRepository studentRepository;

    // --- INSERT (Create) ---

    /**
     * Crea una nueva escuela en la base de datos.
     * @param school Objeto escuela a guardar.
     * @return La escuela guardada.
     */
    public School createSchool(School school) {
        return schoolRepository.save(school);
    }

    // --- GET ALL (Read) ---

    /**
     * Obtiene todas las escuelas registradas.
     * @return Lista de escuelas.
     */
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    // --- GET ELEMENT (Read by ID) ---

    /**
     * Obtiene una escuela por su ID.
     * @param id Identificador de la escuela.
     * @return Optional con la escuela si existe.
     */
    public Optional<School> getSchoolById(Long id) {
        return schoolRepository.findById(id);
    }

    // --- UPDATE (Update) ---

    /**
     * Actualiza los datos de una escuela existente.
     * @param id Identificador de la escuela a modificar.
     * @param schoolDetails Datos nuevos para la escuela.
     * @return La escuela actualizada o null si no existe.
     */
    public School updateSchool(Long id, School schoolDetails) {
        return schoolRepository.findById(id).map(school -> {
            school.setName(schoolDetails.getName());
            // Aquí se pueden actualizar más campos si la entidad crece
            return schoolRepository.save(school);
        }).orElse(null);
    }

    // --- DELETE (Delete) ---

    /**
     * Elimina una escuela por su ID.
     * @param id Identificador de la escuela.
     * @return true si se eliminó, false si no existía.
     */
    public boolean deleteSchool(Long id) {
        if (schoolRepository.existsById(id)) {
            schoolRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // --- Funcionalidad Extra (Relaciones) ---

    /**
     * Añade un estudiante a una escuela existente (Relación 1:N).
     * @param schoolId ID de la escuela.
     * @param student Objeto estudiante a añadir.
     * @return El estudiante guardado con la relación actualizada.
     */
    public Student addStudentToSchool(Long schoolId, Student student) {
        School school = schoolRepository.findById(schoolId)
                .orElseThrow(() -> new RuntimeException("School not found"));
        student.setSchool(school);
        return studentRepository.save(student);
    }
}