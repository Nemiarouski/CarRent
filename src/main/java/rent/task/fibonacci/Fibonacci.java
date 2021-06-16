package rent.task.fibonacci;

import rent.menu.Console;
import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    private Integer firstElement = 0;
    private Integer secondElement = 1;
    private List<Integer> fibonacciNumbers = new ArrayList<>();

    public List<Integer> getFibonacciNumbers() {
        return fibonacciNumbers;
    }

    public void fibonacci(int choice) {
        for (int i = 0; i < choice; i++) {
            Integer thirdElement = firstElement + secondElement;
            fibonacciNumbers.add(thirdElement);
            firstElement = secondElement;
            secondElement = thirdElement;
        }
    }

    public int fibonacciRecursion(int n) {
        if (n < 2) {
            return n;
        }
        return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
    }

    public int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

    public int factorialRecursion(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorialRecursion(n - 1);
    }

    public Integer getNumberByChoice(int choice) {
        return fibonacciNumbers.get(choice - 1);
    }

    public void fibNumbersInit() {
        fibonacciNumbers.add(firstElement);
        fibonacciNumbers.add(secondElement);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.fibNumbersInit();
/*
        System.out.println("Input the number of Fibonacci numbers: ");
        int choice = Integer.parseInt(Console.read());
        fibonacci.fibonacci(choice);
        System.out.println(fibonacci.getNumberByChoice(choice));

        System.out.println("\nFactorial by recursion:");
        System.out.println(fibonacci.factorialRecursion(1));*/

        System.out.println("\nFibonacci by recursion:");
        System.out.println(fibonacci.fibonacciRecursion(3));
    }
}