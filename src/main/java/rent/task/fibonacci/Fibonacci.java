package rent.task.fibonacci;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    private Integer firstElement = 0;
    private Integer secondElement = 1;
    private List<Integer> fibonacciNumbers = new ArrayList<>();

    public int fibonacci(int choice) {
        for (int i = 0; i < choice; i++) {
            Integer thirdElement = firstElement + secondElement;
            firstElement = secondElement;
            secondElement = thirdElement;
        }
        return fibonacciNumbers.get(choice);
    }

    public int fibonacciRecursion(int n) {
        if (n < 2) {
            return n;
        }
        return fibonacciRecursion(n - 1) + fibonacciRecursion(n - 2);
    }

    public int negativeFibonacciRecursion(int n) {
        if (n > -2) {
            return -n;
        }
        return negativeFibonacciRecursion(n + 2) - negativeFibonacciRecursion(n + 1);
    }

    public int generalFib(int n) {
        return n > 0 ? fibonacciRecursion(n) : negativeFibonacciRecursion(n);
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

    public void fibNumbersInit() {
        fibonacciNumbers.add(firstElement);
        fibonacciNumbers.add(secondElement);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.fibNumbersInit();

        System.out.println("Factorial by recursion:");
        System.out.println(fibonacci.factorialRecursion(1));

        System.out.println("Fibonacci by for:");
        System.out.println(fibonacci.fibonacci(5));

        System.out.println("Fibonacci by recursion:");
        System.out.println(fibonacci.fibonacciRecursion(5));

        System.out.println("Negative Fibonacci");
        System.out.println(fibonacci.negativeFibonacciRecursion(-3));
    }
}