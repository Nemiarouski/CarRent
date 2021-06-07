package rent.maps;

import java.util.ArrayList;
import java.util.List;

public class LambdaTest {
    public static void main(String[] args) {

        InterfaceOne iOne = new InterfaceOne() {
            @Override
            public int getNumber(int a, int b) {
                return a + b;
            }
        };

        InterfaceOne iTwo = (a, b) -> a + b;

        System.out.println(iOne.getNumber(3,5));
        System.out.println(iTwo.getNumber(3,5));

        //Task 1
        TaskOne taskOne = a -> a % 13 == 0;
        System.out.println(taskOne.count(39));

        //Task 2
        TaskTwo taskTwo = (x, y) -> {
            if (x.length() > y.length()) {
                return x;
            } else {
                return y;
            }
        };

        TaskTwo taskTwo1 = (x, y) -> {
            return x.length() > y.length() ? x : y;
        };
        //TaskTwo taskTwo2 = (x, y) -> x.equals(y) ? return x : return y;
        //TaskTwo taskTwo3 = (x, y) ->

        System.out.println(taskTwo.diff("Another", "One12345"));

        //Task 3
        TaskThree<Double> taskThree = (a,b, c) -> (b * b) - (4 * a * c);
        System.out.println(taskThree.operation(4.0,9.0,2.0));

        //Task 4
        TaskThree<Integer> taskFour = (a, b, c) -> a * (b ^ c);
        System.out.println(taskFour.operation(3,5,3));


        List<String> stringList = new ArrayList<>();
        stringList.add("Hello!");
        stringList.add("It is");
        stringList.add("A");
        stringList.add("Test line");

        stringList.stream().filter(s -> LambdaTest.stringEquals(s)).forEach(System.out::println);


    }
    public static boolean stringEquals(String s) {
        return s.length() > 5;
    }
}