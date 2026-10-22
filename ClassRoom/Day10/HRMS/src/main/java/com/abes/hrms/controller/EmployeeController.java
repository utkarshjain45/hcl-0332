package com.abes.hrms.controller;

import com.abes.hrms.model.DemoEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private DemoEmployee demoEmployee;

    @GetMapping
    public String welcome(){
        return "Welcome to HRMS";
    }

    @GetMapping("/add")
    public int sum(){
        return demoEmployee.add(20, 40);
    }

    @GetMapping("/sqrt")
    public double sqrt(){
        return demoEmployee.sqrt(16);
    }

    @GetMapping("/gtn")
    public int gtn(){
        return demoEmployee.greater(30, 40);
    }
}
