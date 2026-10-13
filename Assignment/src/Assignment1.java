import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

abstract class Employee implements Comparable<Employee> {
    int empId;
    String name;
    double basic;
    double hra;

    public Employee(int empId, String name, double basic, double hra) {
        this.empId = empId;
        this.name = name;
        this.basic = basic;
        this.hra = hra;
    }

    abstract double calculateBonus();

    @Override
    public int compareTo(Employee o) {
        return Double.compare(o.calculateBonus(), this.calculateBonus());
    }
}

class Manager extends Employee{
    public Manager(int empId, String name, double basic, double hra) {
        super(empId, name, basic, hra);
    }

    @Override
    double calculateBonus() {
        return (basic + hra) * 0.12;
    }
}

class Admin extends Employee{
    public Admin(int empId, String name, double basic, double hra) {
        super(empId, name, basic, hra);
    }

    @Override
    double calculateBonus() {
        return (basic + hra) * 0.10;
    }
}

class Engineer extends Employee{
    public Engineer(int empId, String name, double basic, double hra) {
        super(empId, name, basic, hra);
    }

    @Override
    double calculateBonus() {
        return (basic + hra) * 0.12;
    }
}

class Accountant extends Employee{
    public Accountant(int empId, String name, double basic, double hra) {
        super(empId, name, basic, hra);
    }

    @Override
    double calculateBonus() {
        return (basic + hra) * 0.08;
    }
}

public class Assessment1 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Manager(1, "Amit", 50000, 15000));
        employees.add(new Admin(2, "Priya", 30000, 10000));
        employees.add(new Engineer(3, "Rahul", 40000, 10000));
        employees.add(new Accountant(4, "Neha", 35000, 10000));
        employees.add(new Engineer(5, "Karan", 60000, 15000));

        Collections.sort(employees);

        for (Employee e : employees){
            System.out.println("Emp_id: " + e.empId + "\n" +
                                "Name: " + e.name + "\n" +
                                "Bonus: " + e.calculateBonus() + "\n" +
                                "----------------------------------");
        }
    }
}