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

   @Autowired
    private PositionService positionService;

    @Autowired
    private BanqueService banqueService;

    @Autowired
    private TypeCongeService typeCongeService;

    @Autowired
    private EtatCivilService etatCivilService;

    @Autowired
    private DepartementService departementService;



    public Optional<Employee> getEmployee(int id){
        return employeeRepository.findById(id);
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public Employee save(Employee employee){

        employee.setPosition(positionService.getPositionById(employee.getPosition().getId()));
        employee.setBanque(banqueService.getBanqueById(employee.getBanque().getId()));
        employee.setTypeConge(typeCongeService.getTypeCongeById(employee.getTypeConge().getId()));
        employee.setEtatCivil(etatCivilService.getEtatCivilById(employee.getEtatCivil().getId()));
        employee.setDepartement(departementService.getDepartementById(employee.getDepartement().getId()));  
        return employeeRepository.save(employee);
    }

    public void delete(int id){
        employeeRepository.deleteById(id);
    }

}
