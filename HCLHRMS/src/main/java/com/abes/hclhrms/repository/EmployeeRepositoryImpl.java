package com.abes.hclhrms.repository;

import com.abes.hclhrms.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeRepositoryImpl implements EmployeeRepository{

    List<Employee> empList = new ArrayList<>();

    @Override
    public String addEmployeeBulk(List<Employee> employees) {
        empList.addAll(employees);
        return "Employees added in bulk";
    }

    @Override
    public String addEmp(Employee emp) {
        empList.add(emp);
        return "Employee Added Successfully";
    }

    @Override
    public List<Employee> getEmp() {
        return empList;
    }

    @Override
    public Employee getEmpById(long empId) {
        return empList
                .stream()
                .filter(employee -> employee.getEmp_id() == empId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public String deleteById(long empId) {
        if (getEmpById(empId) != null){
            empList.removeIf(e -> e.getEmp_id() == empId);
            return "Employee Deleted";
        }
        return "Id : " + empId + " Not Found";
    }

    @Override
    public String updateById(long empId, Employee updatedEmp) {
        if (getEmpById(empId) != null){
            empList.removeIf(e -> e.getEmp_id() == empId);
            empList.add(updatedEmp);
            return "Employee Updated";
        }

        return "Not Found to Replace";
    }
}
