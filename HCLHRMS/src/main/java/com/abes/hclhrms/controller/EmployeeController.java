package com.abes.hclhrms.controller;

import com.abes.hclhrms.entity.Employee;
import com.abes.hclhrms.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getEmp();
    }

    @GetMapping("/add")
    public String addEmp(){
        return employeeService.addEmp();
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
    public String updateEmpById(@PathVariable("id") long empId, @RequestBody Employee e){
        return employeeService.updateById(empId, e);
    }

    @GetMapping("/addBulk")
    public String addInBulk(){
        return employeeService.addEmployeeBulk();
    }
}
