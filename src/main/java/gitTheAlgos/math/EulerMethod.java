package gitTheAlgos.math;

import java.util.ArrayList;
import java.util.function.BiFunction;

/**
 * https://en.wikipedia.org/wiki/Euler_method
 *
 * Learning -
 * 1. Using functions in java
 */
public class EulerMethod {
    public static ArrayList<Double> euler(double t0, double tn, double h, double y0, BiFunction<Double, Double, Double> yn) {
        if (t0 > tn || h < 0) {
            /*
             * Invalid input
             **/
            return null;
        }
        ArrayList<Double> points = new ArrayList<>();
        points.add(y0);
        double y = y0;
        for (double i = t0; i < tn; i += h) {
            y = y + h * yn.apply(i, y);
            points.add(y);
        }
        return points;
    }

    /**
     * source - https://github.com/TheAlgorithms/Java/blob/master/src/main/java/com/thealgorithms/maths/EulerMethod.java
     *
     *
     *
     *
     * calculates the next y-value based on the current value of x, y and the
     * stepSize the console.
     *
     * @param xCurrent Current x-value.
     * @param stepSize Step-size on the x-axis.
     * @param yCurrent Current y-value.
     * @param differentialEquation The differential equation to be solved.
     * @return The next y-value.
     */
    public static double eulerStep(
            double xCurrent,
            double stepSize,
            double yCurrent,
            BiFunction<Double, Double, Double> differentialEquation) {
        if (stepSize <= 0) {
            throw new IllegalArgumentException("stepSize should be greater than zero");
        }
        double yNext = yCurrent + stepSize * differentialEquation.apply(xCurrent, yCurrent);
        return yNext;
    }

    /**
     * Loops through all the steps until xEnd is reached, adds a point for each
     * step and then returns all the points
     *
     * @param xStart First x-value.
     * @param xEnd Last x-value.
     * @param stepSize Step-size on the x-axis.
     * @param yStart First y-value.
     * @param differentialEquation The differential equation to be solved.
     * @return The points constituting the solution of the differential
     * equation.
     */
    public static ArrayList<double[]> eulerFull(
            double xStart,
            double xEnd,
            double stepSize,
            double yStart,
            BiFunction<Double, Double, Double> differentialEquation) {
        if (xStart >= xEnd) {
            throw new IllegalArgumentException("xEnd should be greater than xStart");
        }
        if (stepSize <= 0) {
            throw new IllegalArgumentException("stepSize should be greater than zero");
        }

        ArrayList<double[]> points = new ArrayList<double[]>();
        double[] firstPoint = {xStart, yStart};
        points.add(firstPoint);
        double yCurrent = yStart;
        double xCurrent = xStart;

        while (xCurrent < xEnd) {
            // Euler method for next step
            yCurrent = eulerStep(xCurrent, stepSize, yCurrent, differentialEquation);
            xCurrent += stepSize;
            double[] point = {xCurrent, yCurrent};
            points.add(point);
        }

        return points;
    }
}
