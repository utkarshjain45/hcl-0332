package com.abes.hrmsdatabase.controller;

import com.abes.hrmsdatabase.model.Employee;
import com.abes.hrmsdatabase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String message(){
        return "Welcome";
    }

    @GetMapping("/add")
    public String addEmployee(){
        return employeeService.createEmployee();
    }

    @GetMapping("/addBulk")
    public String addInBulk(){
        return employeeService.addEmployeeBulk();
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmp();
    }

    @GetMapping("/get/{id}")
    public Employee getEmpById(@PathVariable("id") long empId){
        return employeeService.getEmpById(empId);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmpById(@PathVariable("id") long empId){
        return employeeService.deleteById(empId);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmpById(@PathVariable("id") Long empId, @RequestBody Employee e){
        return employeeService.updateById(empId, e);
    }
}
