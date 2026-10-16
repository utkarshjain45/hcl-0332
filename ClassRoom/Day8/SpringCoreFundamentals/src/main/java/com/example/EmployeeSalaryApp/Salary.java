package com.example.EmployeeSalaryApp;

public class Salary {
    private double basicSalary;
    private double pf;
    private double hra;

    public double consolidatedSalary(){
        return basicSalary + pf + hra;
    }
}
