package com.abes.hrmsdatabase.service;

import com.abes.hrmsdatabase.model.Employee;
import com.abes.hrmsdatabase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String createEmployee(Employee employee){
        employeeRepository.save(employee);
        return "Employee Added";
    }

    public String login(Long id, String password){
        if(employeeRepository.existsById(id)){
            Employee employee = employeeRepository.findById(id).orElse(null);
            if(employee != null && employee.getPassword() != null && employee.getPassword().equals(password)){
                return "Login Successfull";
            }
        }
        return "Wrong Password";
    }
}
