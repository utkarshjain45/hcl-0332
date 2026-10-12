import java.util.function.*;

public class CalculatorImpl {
    public static void main(String[] args) {
        Calculator add = (a, b) -> {
                return a + b;
        };
        System.out.println(add.calculate(2, 3));

        Calculator sub = (a, b) -> a - b;
        System.out.println(sub.calculate(5, 2));

        Calculator mul = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a * b;
            }
        };
        mul.calculate(2, 3);

        Calculator div = (a, b) -> b / a;
        div.calculate(4, 16);

//        EvenOdd evenOdd = (a) -> {
//            if (a % 2 == 0){
//                System.out.println("Even");
//            } else {
//                System.out.println("Odd");
//            }
//        };

        EvenOdd evenOdd = (a) -> (a % 2 == 0);
        System.out.println(evenOdd.check(3));
        System.out.println(evenOdd.check(4));


        Predicate<Integer> predicate = (a) -> (a % 2 == 0);
        System.out.println(predicate.test(4));

        BiFunction<Integer, Integer, Integer> function = (a, b) -> a * b;
        System.out.println(function.apply(4, 5));

        Supplier<Double> supplier = () -> Math.random();
        System.out.println(supplier.get());

        Consumer<String> consumer = (a) -> System.out.println(a);
        consumer.accept("Hi!!!");


    }
}
