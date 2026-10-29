package com.abes.hrmsdatabase.controller;

import com.abes.hrmsdatabase.model.Employee;
import com.abes.hrmsdatabase.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
@CrossOrigin("http://localhost:5173/")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping({"/register", "/add"})
    public String addEmployee(@RequestBody Employee employee){
        return loginService.createEmployee(employee);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam Long id, @RequestParam String password){
        return ResponseEntity.ok(loginService.login(id, password));
    }
}
