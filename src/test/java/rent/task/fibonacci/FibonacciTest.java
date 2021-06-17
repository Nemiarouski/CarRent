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
        List<Integer> range = List.of(-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        for (int i = 0; i <range.size(); i++) {
            assertEquals(expected.get(i), fibonacci.generalFib(range.get(i)));
        }
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