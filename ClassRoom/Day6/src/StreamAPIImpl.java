package Day6.src;

import java.util.ArrayList;
import java.util.List;

public class StreamAPIImpl {
    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(2);
        ls.add(3);
        ls.add(4);

        System.out.println(ls.stream().filter(a -> a % 2 == 0).toList());
        System.out.println(ls.stream().map(a -> a * 2).toList());

        System.out.println(ls.stream().filter(a -> a % 2 == 0).count());

        ls.stream().forEach(System.out::println);

        List<String> list = new ArrayList<>();
        list.add("Rohan");
        list.add("Sumit");
        list.add("Rahul");
        list.add("Mohan");
        list.add("Prachi");
        list.add("Priya");

        System.out.println(list.stream().filter(e -> e.startsWith("R")).toList());

        System.out.println(list.stream().filter(e -> e.endsWith("n")).toList());

        System.out.println(list.stream().findFirst().get());
    }
}
