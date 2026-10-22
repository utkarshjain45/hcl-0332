package com.abes.hrms.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository {
    double squareRoot(double d);
    String empData();
    int add(int a, int b);
    int greater(int a, int b);
}
