package com.example.di.FieldDI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Employee {

    @Autowired
    private Address address;

    public void setAddress(Address address){
        this.address = address;
    }

    public void display(){
        System.out.println("Employee");
    }
}
