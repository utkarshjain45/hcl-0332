package com.example.EmployeeSalaryApp;

import org.springframework.context.annotation.Bean;

public class AppConfig {

    @Bean
    public Address address(){
        return new Address();
    }

    @Bean
    public Department department(){
        return new Department();
    }

    @Bean
    public Salary salary(){
        return new Salary();
    }

    @Bean
    public Employee employee(Address address, Department department, Salary salary){
        return new Employee(salary, address, department);
    }
}
