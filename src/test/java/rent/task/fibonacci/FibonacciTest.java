package rent.task.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void getNumberByChoice() {
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.fibNumbersInit();
        fibonacci.fibonacci(0);
        int real = fibonacci.getNumberByChoice(0);

        assertEquals(0, real);
    }

    @Test
    void fabNumbersInit() {
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.getFibonacciNumbers().size();
    }

    @Test
    void fibRecursion() {
        Fibonacci fibonacci = new Fibonacci();
        int n = fibonacci.fibonacciRecursion(3);
        assertEquals(2, n);
    }

    @Test
    void factorial() {
        Fibonacci fibonacci = new Fibonacci();
        int real = fibonacci.factorial(0);
        assertEquals(1, real);
    }

    @Test
    void factorialByRecursion() {
        Fibonacci fibonacci = new Fibonacci();
        int real = fibonacci.factorialRecursion(4);
        assertEquals(24, real);
    }
}