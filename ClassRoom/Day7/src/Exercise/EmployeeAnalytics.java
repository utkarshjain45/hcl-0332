package Day7.src.Exercise;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeAnalytics {
    record Employee(int id, String name, String dept, BigDecimal salary,
                    LocalDate hireDate, Set<String> skills){}

    static Employee e(int id, String n, String d, int sal, String date, String... skills){
        return new Employee(id, n, d, BigDecimal.valueOf(sal),
                LocalDate.parse(date), Set.of(skills));
    }

    public static void main(String[] args) {
        List<Employee> emps = List.of(
                e(1, "Asha",   "Engineering",  90000, "2019-03-01", "Java", "SQL"),
                e(2, "Ravi",   "Engineering", 120000, "2016-07-15", "Java", "Spring", "AWS"),
                e(3, "Meera",  "HR",           60000, "2020-01-10", "Recruiting"),
                e(4, "John",   "Sales",        70000, "2018-11-20", "Negotiation", "CRM"),
                e(5, "Priya",  "Engineering", 105000, "2021-05-05", "Java", "React"),
                e(6, "Karan",  "Sales",        65000, "2022-02-14", "CRM"),
                e(7, "Sara",   "HR",           62000, "2017-09-09", "Recruiting", "Payroll"),
                e(8, "Vikram", "Finance",      80000, "2015-04-30", "Excel", "SQL")
        );

//        ------------------------Solution of Q1---------------------------------
//         emps.stream()
//                 .filter(e -> e.dept.equals("Engineering"))
//                 .sorted(Comparator.comparing((Employee e) -> e.salary).reversed())
//                 .forEach(e -> System.out.println(e.name));
//        emps.stream()
//                .filter(e -> e.dept.equals("Engineering"))
//                .sorted((e1, e2) -> e2.salary.compareTo(e1.salary))
//                .forEach(e -> System.out.println(e.name));

//        -------------------Solution of Q2------------------------------
//        emps.stream()
//                .sorted(Comparator.comparing(Employee::salary).reversed())
//                .limit(3)
//                .forEach(e -> System.out.println(e.name));

//      ------------------------Solution of Q3--------------------------------
//        emps.stream()
//                .filter(e -> e.hireDate.isBefore(LocalDate.of(2018, 1, 1)))
//                .sorted(Comparator.comparing(Employee::hireDate))
//                .forEach(e -> System.out.println(e.name + " (" + e.hireDate.getYear() + ")"));

//      -------------------------Solution Of Q4---------------------------------
        String joined = emps.stream()
                .map(Employee::name)
                .collect(Collectors.joining(", "));
        System.out.println(joined);

//        Solution Of Q5


    }
}
