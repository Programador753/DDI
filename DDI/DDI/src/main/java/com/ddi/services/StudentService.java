package com.ddi.services;

import com.ddi.exceptions.StudentNotFoundException;
import com.ddi.models.Student;
import com.ddi.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public List<Student> getAllStudents() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    public Student newStudent(@RequestBody Student newStudent) {
        return repository.save(newStudent);
    }

    // Se podria cambiar el optional por return Student si pusiesemos una
    // exception creada por nosotros.
    public Student getStudent(@PathVariable Long id) throws StudentNotFoundException  {
        return repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with id = " + id + " not found."));
        // return repository.findById(id)
        //      .orElseThrow(() -> new StudentNotFoundException(id));
    }

    public Student replaceStudent(@RequestBody Student newStudent, @PathVariable Long id) {
        return repository.findById(id)
                .map(student -> {
                    student.setName(newStudent.getName());
                    student.setRole(newStudent.getRole());
                    return repository.save(student);
                })
                .orElseGet(() -> {
                    return repository.save(newStudent);
                });
    }

    public void deleteStudent(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
