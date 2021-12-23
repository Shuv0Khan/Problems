package gitTheAlgos.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;

class EulerMethodTest {
    @Test
    @DisplayName("basic test")
    void basicTest() {
        BiFunction<Double, Double, Double> exampleEquation1 = (x, y) -> x;
        ArrayList<double[]> points1 = EulerMethod.eulerFull(0, 4, 0.1, 0, exampleEquation1);
        ArrayList<Double> points2 = EulerMethod.euler(0,4,0.1,0, exampleEquation1);
        for(int i = 0; i < points1.size(); i++) {
            assertEquals(points1.get(i)[1], points2.get(i));
        }

        // example from https://en.wikipedia.org/wiki/Euler_method
        BiFunction<Double, Double, Double> exampleEquation2 = (x, y) -> y;
        points1 = EulerMethod.eulerFull(0, 4, 0.1, 1, exampleEquation2);
        points2 = EulerMethod.euler(0, 4, 0.1, 1, exampleEquation2);
        for(int i = 0; i < points1.size(); i++) {
            assertEquals(points1.get(i)[1], points2.get(i));
        }

        // example from https://www.geeksforgeeks.org/euler-method-solving-differential-equation/
        BiFunction<Double, Double, Double> exampleEquation3 = (x, y) -> x + y + x * y;
        points1 = EulerMethod.eulerFull(0, 0.1, 0.025, 1, exampleEquation3);
        points2 = EulerMethod.euler(0, 0.1, 0.025, 1, exampleEquation3);
        for(int i = 0; i < points1.size(); i++) {
            assertEquals(points1.get(i)[1], points2.get(i));
        }
    }
}