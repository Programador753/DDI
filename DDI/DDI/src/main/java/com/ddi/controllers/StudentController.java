package com.ddi.controllers;

import com.ddi.exceptions.StudentNotFoundException;
import com.ddi.models.Student;
import com.ddi.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class that implements a Student Controller
 *
 * @author Alvaro Juan Ciriaco
 */
@RestController
class StudentController {

    /**
     * Link with student service
     */
    @Autowired
    private StudentService studentService;

    /**
     * Get method to obtain all students
     * @return a list of all students stored in the database
     */
    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    /**
     * Post method to insert a new student
     * @param json Contains the new student to be inserted
     * @return the new student added to the database in json format
     */
    @PostMapping("/students")
    public Student newStudent(@RequestBody Student json) {
        return studentService.newStudent(json);
    }

    /**
     * Get method to obtain a specific student
     * @param id identifier of the student you want to obtain
     * @return student whose id is {id}
     * @throws StudentNotFoundException if student doesn't exist
     */
    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable Long id) throws StudentNotFoundException {
        return studentService.getStudent(id);
    }

    /**
     * Put method to replace a specific student
     * @param newStudent new data to insert
     * @param id identifier of the student you want to replace
     * @return the student replaced in json format
     */
    @PutMapping("/students/{id}")
    public Student replaceStudent(@RequestBody Student newStudent, @PathVariable Long id) {
        return studentService.replaceStudent(newStudent, id);
    }

    /**
     * Delete method to delete a specific student
     * @param id identifier of the student you want to delete
     */
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}