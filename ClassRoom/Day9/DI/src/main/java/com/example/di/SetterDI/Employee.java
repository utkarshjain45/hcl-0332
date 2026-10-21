package com.example.di.SetterDI;

public class Employee {
    private Address address;

    public void setAddress(Address address){
        this.address = address;
    }

    public void display(){
        System.out.println("Employee");
    }
}
