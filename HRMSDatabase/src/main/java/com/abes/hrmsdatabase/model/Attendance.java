package com.abes.hrmsdatabase.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "attendance")
public class Attendance {

    @Id
    @Column(name = "attendanceId", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendanceId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "empId")
    private Employee employee;

    @Column(nullable = false)
    private LocalDate attendanceDate;

    private LocalDate inTime;

    private LocalDate outTime;

    public Attendance(){}

    public Attendance(Long attendanceId, Employee employee, LocalDate attendanceDate, LocalDate inTime, LocalDate outTime) {
        this.attendanceId = attendanceId;
        this.employee = employee;
        this.attendanceDate = attendanceDate;
        this.inTime = inTime;
        this.outTime = outTime;
    }

    public Long getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Long attendanceId) {
        this.attendanceId = attendanceId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setEmpId(Long empId) {
        if (this.employee == null) {
            this.employee = new Employee();
        }
        this.employee.setEmpId(empId);
    }

    public LocalDate getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(LocalDate attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public LocalDate getInTime() {
        return inTime;
    }

    public void setInTime(LocalDate inTime) {
        this.inTime = inTime;
    }

    public LocalDate getOutTime() {
        return outTime;
    }

    public void setOutTime(LocalDate outTime) {
        this.outTime = outTime;
    }
}
