package rent.task.fibonacci;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {
    @Test
    void genFib(){
        Fibonacci fibonacci = new Fibonacci();
        List<Integer> expected = List.of(-55, 34, -21, 13, -8, 5, -3, 2, -1, 1, 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55);
        List<Integer> actual = new ArrayList<>();
        for (int i = -10; i <= 10; i++) {
            actual.add(fibonacci.generalFib(i));
        }
        assertEquals(expected, actual);
    }

    @Test
    void fibRecursion() {
        Fibonacci fibonacci = new Fibonacci();
        int n = fibonacci.fibonacciRecursion(5);
        assertEquals(5, n);
    }

    @Test
    void negFibRecursion() {
        Fibonacci fibonacci = new Fibonacci();
        int real = fibonacci.negativeFibonacciRecursion(-9);
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