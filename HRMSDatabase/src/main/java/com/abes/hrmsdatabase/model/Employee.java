package com.abes.hrmsdatabase.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
    public Employee() {}

    public Employee(Long id, String emp_name, String stack, String designation) {
        this.id = id;
        this.emp_name = emp_name;
        this.stack = stack;
        this.designation = designation;
    }

    @Id
    private Long id;

    private String emp_name;

    private String stack;

    private String designation;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
