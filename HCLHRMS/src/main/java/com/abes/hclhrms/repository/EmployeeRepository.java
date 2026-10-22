package com.abes.hclhrms.repository;

import com.abes.hclhrms.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository {
    public String addEmp(Employee emp);

    List<Employee> getEmp();

    String addEmployeeBulk(List<Employee> employees);

    Employee getEmpById(long empId);

    String deleteById(long empId);

    String updateById(long empId, Employee updatedEmp);
}
