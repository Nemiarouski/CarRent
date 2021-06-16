package rent.task.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void fibRecursion() {
        Fibonacci fibonacci = new Fibonacci();
        int n = fibonacci.fibonacciRecursion(5);
        assertEquals(5, n);
    }

    @Test
    void negFibRecursion() {
        Fibonacci fibonacci = new Fibonacci();
        int real = fibonacci.negativeFibonacciRecursion(-6);
        assertEquals(-8, real);
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