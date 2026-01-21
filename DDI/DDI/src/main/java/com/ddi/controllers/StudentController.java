package com.ddi.controllers;

import com.ddi.exceptions.EmployeeNotFoundException;
import com.ddi.models.Employee;
import com.ddi.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class that implements an Employee Controller
 *
 * @author Alvaro Juan Ciriaco
 */
@RestController
class StudentController {

    /**
     * Link with employee service
     */
    @Autowired
    private EmployeeService employeeService;

    /**
     * Get method to obtain all employees
     * @return a list of all employees stored in the database
     */
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    /**
     * Post method to insert a new employee
     * @param json Contains the new employee to be inserted
     * @return the new employee added to the database in json format
     */
    @PostMapping("/EmployeeController")
    public Employee newEmployee(@RequestBody Employee json) {
        return employeeService.newEmployee(json);
    }

    /**
     * Get method to obtain a specific employee
     * @param id identifier of the employee you want to obtain
     * @return employee whose id is {id}
     * @throws EmployeeNotFoundException if address doesn't exist
     */
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Long id) throws EmployeeNotFoundException {
        return employeeService.getEmployee(id);
    }

    /**
     * Put method to replace a specific employee
     * @param newEmployee new data to insert
     * @param id identifier of the employee you want to replace
     * @return the employee replaced in json format
     */
    @PutMapping("/employees/{id}")
    public Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
        return employeeService.replaceEmployee(newEmployee, id);
    }

    /**
     * Delete method to replace a specific employee
     * @param id identifier of the employee you want to delete
     */
    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}