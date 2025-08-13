package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorTest {

    private Calculator sut;

    @BeforeEach
    void setup() {
        sut = new Calculator();
    }
    @Test
    void test_average() {
        int a = Integer.MAX_VALUE;
       /* int result = sut.add(a, 1);
        System.out.println(result);*/
        assertThrows(ArithmeticException.class, () -> sut.add(a, 1));
    }
}

class Calculator {

    public double calculateAverage(int a, int b, int c, int d, int e) {
        int sum = a + b + c + d + e;
        return (double)sum / 5;
    }

    public int add(int a, int b) {
        if( a > Integer.MAX_VALUE - b){
            throw new ArithmeticException("Überlauf in result");
        }
        return a + b;
    }
}
