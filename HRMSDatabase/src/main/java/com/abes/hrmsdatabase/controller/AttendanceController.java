package com.abes.hrmsdatabase.controller;

import com.abes.hrmsdatabase.model.Attendance;
import com.abes.hrmsdatabase.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users/attendance")
@CrossOrigin("http://localhost:5173/")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/mark")
    public ResponseEntity<String> markAttendance(@RequestBody Attendance attendance){
        return ResponseEntity.ok(attendanceService.markAttendance(attendance));
    }

    @PostMapping("/checkout")
    public ResponseEntity<String> checkOut(@RequestParam Long empId){
        return ResponseEntity.ok(attendanceService.checkOut(empId));
    }

    @GetMapping("/status/{empId}")
    public ResponseEntity<Attendance> getTodayAttendance(@PathVariable Long empId){
        return ResponseEntity.ok(attendanceService.getTodayAttendance(empId));
    }

    @GetMapping("/today")
    public ResponseEntity<List<Attendance>> getTodayAllAttendance(){
        return ResponseEntity.ok(attendanceService.getTodayAllAttendance());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Attendance>> getAllAttendance(){
        return ResponseEntity.ok(attendanceService.getAllAttendance());
    }
}
