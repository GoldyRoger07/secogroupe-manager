package com.secogroupe.manager.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secogroupe.manager.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
      // public Employee findById(Integer id);
}
