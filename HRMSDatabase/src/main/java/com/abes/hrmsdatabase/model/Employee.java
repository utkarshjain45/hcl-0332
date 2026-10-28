package com.abes.hrmsdatabase.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
    public Employee() {}

    public Employee(Long id, String emp_name, String stack, String designation, String email, String password) {
        this.id = id;
        this.emp_name = emp_name;
        this.stack = stack;
        this.designation = designation;
        this.email = email;
        this.password = password;
    }

    @Id
    private Long id;

    private String emp_name;

    private String stack;

    private String designation;

    private String email;

    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
