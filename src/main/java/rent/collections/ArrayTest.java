package rent.collections;

import java.util.*;

public class ArrayTest {
    private static List<Integer> listOfIntegers = new LinkedList<>();

    public static void arrayInit() {
        listOfIntegers.add(1);
        listOfIntegers.add(-2);
        listOfIntegers.add(6);
        listOfIntegers.add(0);
        listOfIntegers.add(null);
    }

    public static void out() {
        listOfIntegers.forEach(System.out::println);
    }

    public static void main(String[] args) {
        arrayInit();
        out();
    }
}