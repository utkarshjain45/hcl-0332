package Day6.src;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDetails {
    public static void main(String[] args) {
        List<Employees> employees = new ArrayList<>();

        employees.add(new Employees(1, "Rahul", 35000.0, "IT"));
        employees.add(new Employees(2, "Priya", 42000.0, "HR"));
        employees.add(new Employees(3, "Amit", 50000.0, "Finance"));
        employees.add(new Employees(4, "Sneha", 38000.0, "Marketing"));
        employees.add(new Employees(5, "Vikas", 60000.0, "IT"));
        employees.add(new Employees(6, "Neha", 45000.0, "Sales"));
        employees.add(new Employees(7, "Arjun", 55000.0, "Finance"));
        employees.add(new Employees(8, "Pooja", 40000.0, "HR"));
        employees.add(new Employees(9, "Karan", 65000.0, "IT"));
        employees.add(new Employees(10, "Anjali", 48000.0, "Marketing"));

        employees.stream().filter(e -> e.name.startsWith("a") || e.name.startsWith("A")).map(e -> e.name.toUpperCase()).sorted().forEach(System.out::println);

        employees.stream().collect(Collectors.groupingBy(e -> e.dept, Collectors.summingDouble(e -> e.salary)));
    }
}

class Employees {
    int id;
    String name;
    Double salary;
    String dept;

    public Employees(int id, String name, Double salary, String dept) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.dept = dept;
    }
}