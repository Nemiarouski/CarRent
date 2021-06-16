package rent.task.fibonacci;

import rent.menu.Console;
import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    private static Integer firstElement = 0;
    private static Integer secondElement = 1;
    private static List<Integer> fibonacciNumbers = new ArrayList<>();

    public static void fillFibonacciNumbers(int choice) {
        for (int i = 0; i < choice; i++) {
            Integer thirdElement = firstElement + secondElement;
            fibonacciNumbers.add(thirdElement);
            firstElement = secondElement;
            secondElement = thirdElement;
        }
    }

    public static Integer getNumberByChoice(int choice) {
        return fibonacciNumbers.get(choice);
    }

    public static void fibNumbersInit() {
        fibonacciNumbers.add(firstElement);
        fibonacciNumbers.add(secondElement);
    }

    public static void main(String[] args) {
        fibNumbersInit();
        System.out.println("Input the number of Fibonacci numbers: ");
        int choice = Integer.parseInt(Console.read());
        fillFibonacciNumbers(choice);
        System.out.println(getNumberByChoice(choice));
    }
}
