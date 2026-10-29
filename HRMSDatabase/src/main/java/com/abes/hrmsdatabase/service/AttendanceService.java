package com.abes.hrmsdatabase.service;

import com.abes.hrmsdatabase.model.Attendance;
import com.abes.hrmsdatabase.model.Employee;
import com.abes.hrmsdatabase.repository.AttendanceRepository;
import com.abes.hrmsdatabase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public String markAttendance(Attendance attendance){
        if (attendance.getEmployee() == null || attendance.getEmployee().getEmpId() == null) {
            return "Employee ID missing";
        }
        Long empId = attendance.getEmployee().getEmpId();
        if (employeeRepository.existsById(empId)){
            if (!attendanceRepository.existsByEmployee_EmpIdAndAttendanceDate(empId, LocalDate.now())){
                Employee emp = employeeRepository.findById(empId).orElse(null);
                attendance.setEmployee(emp);
                if (attendance.getAttendanceDate() == null) {
                    attendance.setAttendanceDate(LocalDate.now());
                }
                if (attendance.getInTime() == null) {
                    attendance.setInTime(LocalDate.now());
                }
                attendanceRepository.save(attendance);
                return "Attendance Marked Successfully";
            }
            return "Attendace already marked";
        }
        return "Employee not found";
    }

    public String checkOut(Long empId){
        if (empId == null) {
            return "Employee ID missing";
        }
        Optional<Attendance> optionalAttendance = attendanceRepository.findByEmployee_EmpIdAndAttendanceDate(empId, LocalDate.now());
        if (optionalAttendance.isPresent()){
            Attendance att = optionalAttendance.get();
            att.setOutTime(LocalDate.now());
            attendanceRepository.save(att);
            return "Checked Out Successfully";
        }
        return "No Check-in found for today";
    }

    public Attendance getTodayAttendance(Long empId){
        return attendanceRepository.findByEmployee_EmpIdAndAttendanceDate(empId, LocalDate.now()).orElse(null);
    }

    public List<Attendance> getTodayAllAttendance() {
        return attendanceRepository.findByAttendanceDate(LocalDate.now());
    }

    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }
}
