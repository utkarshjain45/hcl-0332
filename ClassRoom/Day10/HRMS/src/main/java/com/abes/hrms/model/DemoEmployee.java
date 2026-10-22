package com.abes.hrms.model;

import com.abes.hrms.repository.EmployeeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoEmployee {

    @Autowired
    private EmployeeRepositoryImpl employeeRepository;


    public double sqrt(double d){
        return employeeRepository.squareRoot(d);
    }

    public int add(int a, int b){
        return employeeRepository.add(a, b);
    }

    public int greater(int a, int b){
        return employeeRepository.greater(a, b);
    }
}
