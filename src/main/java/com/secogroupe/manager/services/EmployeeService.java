package com.secogroupe.manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secogroupe.manager.models.Employee;
import com.secogroupe.manager.repositorys.EmployeeRepository;

@Service
public class EmployeeService {
    

    @Autowired
    private EmployeeRepository employeeRepository;


    public Optional<Employee> getEmployee(int id){
        return employeeRepository.findById(id);
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public void delete(int id){
        employeeRepository.deleteById(id);
    }

}
