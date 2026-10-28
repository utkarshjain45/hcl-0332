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

    public String createEmployee(Employee employee){
        employeeRepository.save(employee);
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

    public String addEmployeeBulk(List<Employee> employees) {
//        List<Employee> employees = List.of(
//                new Employee(201l, "Priya", "Python", "USER", "priya@example.in", "priya"),
//                new Employee(202l, "Amit", "Java", "ADMIN", "amit@example.in", "amit"),
//                new Employee(203l, "Sneha", "JavaScript", "USER", "sneha@example.in", "sneha"),
//                new Employee(204l, "Vikram", "Spring Boot", "MANAGER", "vikram@example.in", "vikram"));
//

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
