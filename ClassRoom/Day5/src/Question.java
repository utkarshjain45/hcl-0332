import java.util.*;

public class Question {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Rohan", 50000.0));
        employees.add(new Employee(2, "Sohan", 13000.0));
        employees.add(new Employee(3, "Harry", 30000.0));
        employees.add(new Employee(4, "Rahul", 18000.0));
        employees.add(new Employee(5, "Sumit", 23000.0));

        //Iterate using Simple Iterator
        Iterator<Employee> it = employees.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("-------------------------------");

        //Iterate using List Iterator
        ListIterator<Employee> lit = employees.listIterator();
        while (lit.hasNext()){
            System.out.println(lit.next());
        }
        System.out.println("-------------------------------");

        //Employees in Ascending order on salary
        employees.sort(Comparator.comparingDouble(Employee::getSalary));
        for (Employee e : employees){
            System.out.println(e);
        }
        System.out.println("-------------------------------");

        //Employees in Descending order on salary
        employees.sort(Comparator.comparingDouble(Employee::getSalary).reversed());
        for(Employee e : employees){
            System.out.println(e);
        }
        System.out.println("-------------------------------");
    }
}
