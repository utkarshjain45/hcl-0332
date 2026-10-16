package com.example.EmployeeSalaryApp;

public class Employee {
    private String name;
    private final Salary salary;
    private final Address address;
    private final Department department;

    public Employee(Salary salary, Address address, Department department) {
        this.salary = salary;
        this.address = address;
        this.department = department;
    }

    public void display(){
        System.out.println(
                "name=" + name + "\n" +
                ", salary=" + salary.consolidatedSalary() + "\n" +
                ", address=" + address + "\n" +
                ", department=" + department + "\n"
        );
    }
}
