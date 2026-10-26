package com.abes.hrmsdatabase.service;

import com.abes.hrmsdatabase.model.Employee;
import com.abes.hrmsdatabase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String createEmployee(){
        Employee emp1 = new Employee(200l, "Rahul", "Java", "ADMIN");
        employeeRepository.save(emp1);
        return "Employee Added";
    }

    public List<Employee> getAllEmp() {
        return employeeRepository.findAll();
    }

    public Employee getEmpById(long empId) {
        Employee e = employeeRepository.getById(empId);
        return e;
    }

    public String deleteById(long empId) {
        if(employeeRepository.existsById(empId)){
            employeeRepository.deleteById(empId);
        }
        return "Employee Deleted";
    }

    public String addEmployeeBulk() {
        List<Employee> employees = List.of(
                new Employee(201l, "Priya", "USER", "Python"),
                new Employee(202l, "Amit", "ADMIN", "Java"),
                new Employee(203l, "Sneha", "USER", "JavaScript"),
                new Employee(204l, "Vikram", "MANAGER", "Spring Boot"));


        employeeRepository.saveAll(employees);
        return "All Employees Added";
    }

    public Employee updateById(long empId, Employee e) {
        if(employeeRepository.existsById(empId)){
            employeeRepository.deleteById(empId);
        }

        return employeeRepository.save(e);
    }
}
