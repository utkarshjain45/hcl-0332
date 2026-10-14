package Day7.src;

import java.util.Scanner;

public class SwitchImpl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String day = sc.next();

        switch (day) {
            case "Saturday" :
                System.out.println("Weekend");
                break;

            case "Sunday" :
                System.out.println("Weekend");
                break;

            default:
                System.out.println("Weekday");
        }

        String s = switch (day){
            case "Saturday" :
                yield  "Weekend";


            case "Sunday" :
                yield  "Weekend";


            default:
                yield "";
        };


        switch (day){
            case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> System.out.println("Weekday");
            case "Saturday", "Sunday" -> System.out.println("Weekend");
        }
    }
}
