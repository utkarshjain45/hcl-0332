package com.abes.hclhrms.service;

import com.abes.hclhrms.entity.Employee;
import com.abes.hclhrms.repository.EmployeeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl {

    @Autowired
    private EmployeeRepositoryImpl repository;

    public String addEmp(){
        Employee emp1 = new Employee(1, "Rohan", "ADMIN", "Java", "admin@example.org");
        return repository.addEmp(emp1);
    }

    public List<Employee> getEmp(){
        return repository.getEmp();
    }

    public Employee getEmpById(long empId) {
        return repository.getEmpById(empId);
    }

    public String deleteById(long empId) {
        return repository.deleteById(empId);
    }

    public String updateById(long empId, Employee updatedEmp) {
        return repository.updateById(empId, updatedEmp);
    }

    public String addEmployeeBulk() {
        List<Employee> employees = List.of(
                new Employee(1, "Priya", "USER", "Python", "priya@example.org"),
                new Employee(2, "Amit", "ADMIN", "Java", "amit@example.org"),
                new Employee(3, "Sneha", "USER", "JavaScript", "sneha@example.org"),
                new Employee(4, "Vikram", "MANAGER", "Spring Boot", "vikram@example.org"));


        return repository.addEmployeeBulk(employees);
    }
}
