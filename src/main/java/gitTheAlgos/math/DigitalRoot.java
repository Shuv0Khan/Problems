package gitTheAlgos.math;

/**
 * https://www.omnicalculator.com/math/digital-root#what-is-a-digital-root
 *
 * Learning -
 * 1. There's a surprisingly simple equation to calculate.
 * but the complicated recursion is the first thing I thought of.
 *
 * 2. Be very careful of the base condition in a recursion.
 *
 * 3. If I want the multiplication/division to produce decimal,
 * I need to make sure to use floating points.
 */
public class DigitalRoot {
    public static int digitalRoot(int n) {
        if (n < 10) {
            return n;
        }
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        return digitalRoot(sum);
    }

    public static int digitalRootEqn(int n) {
        return (int) (n - (9 * (Math.ceil(n / 9.0) - 1)));
    }
}
