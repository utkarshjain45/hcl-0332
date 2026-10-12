import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorImpl {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>(5);
        list.add(new Student(1, "Sumit", 18, 67));
        list.add(new Student(2, "Rahul", 19, 75));
        list.add(new Student(3, "Amit", 20, 82));
        list.add(new Student(4, "Priya", 18, 91));
        list.add(new Student(5, "Neha", 19, 73));

        Collections.sort(list, new MyComparator());
//        System.out.println(list);

//        Interf i = () -> {
//            System.out.println("Hello");
//        };
    }
}

class MyComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.age, o2.age);
    }
}

class Student implements Comparable<Student>{
    int roll_no;
    String name;
    int age;
    double marks;

    public Student(int roll_no, String name, int age, double marks){
        this.roll_no = roll_no;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public int compareTo(Student o) {
        return Double.compare(this.marks, o.marks);
    }

    @Override
    public String toString() {
        return "Student{" +
                "roll_no=" + roll_no +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", marks=" + marks +
                '}';
    }
}