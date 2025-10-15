package com.secogroupe.manager.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secogroupe.manager.models.Employee;
import com.secogroupe.manager.services.EmployeeService;

@RestController
@RequestMapping("/secogroupe-manager/api")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    
    
    @GetMapping("/employees")
    public List<Employee> getAll() {
        return employeeService.getEmployees();
    }

    @PostMapping("/employee")
    public Employee create(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @GetMapping("/employee/{id}")
    public Employee getById(@PathVariable int id) {
        Optional<Employee> empOpt = employeeService.getEmployee(id);
        return empOpt.get();
    }

    @DeleteMapping("/employee/{id}")
    public void delete(@PathVariable int id) {
        employeeService.delete(id);
    }
}
