package com.abes.hrms.repository;

import org.springframework.stereotype.Component;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository{
    @Override
    public double squareRoot(double d) {
        return Math.sqrt(d);
    }

    @Override
    public String empData() {
        return "Employee Data";
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int greater(int a, int b) {
        return Math.max(a, b);
    }
}
