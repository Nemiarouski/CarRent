package rent.task.fibonacci;

import rent.menu.Console;
import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    private static Integer firstElement = 0;
    private static Integer secondElement = 1;
    private static Integer thirdElement;
    private static List<Integer> fibonacciNumbers = new ArrayList<>();

    public static void fillFibonacciNumbers(int choice) {
        fibonacciNumbers.add(firstElement);
        fibonacciNumbers.add(secondElement);

        for (int i = 0; i < choice; i++) {
            thirdElement = firstElement + secondElement;
            fibonacciNumbers.add(thirdElement);
            firstElement = secondElement;
            secondElement = thirdElement;
        }
        System.out.println(fibonacciNumbers.get(choice - 1));
    }

    public static void main(String[] args) {
        System.out.println("Input the number of Fibonacci numbers: ");
        int choice = Integer.parseInt(Console.read());
        fillFibonacciNumbers(choice);
    }
}
