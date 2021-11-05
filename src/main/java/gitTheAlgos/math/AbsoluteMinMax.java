package gitTheAlgos.math;

/**
 * description:
 *
 * <p>absMax([0, 5, 1, 11]) = 11, absMax([3 , -10, -2]) = -10
 *
 * Lesson -
 * 1. When finding min/max, be careful to check for zero.
 * If an input is such that the min/max is zero, the checks must include it.
 *
 * else if (num >= 0 && num < min)
 *
 * 2. No need to multiply by -1 in java. just use -num.
 */
public class AbsoluteMinMax {
    public static int absMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sign = 1;
        for (int num : nums) {
            if (num < 0 && -num < min) {
                min = -num;
                sign = -1;
            } else if (num >= 0 && num < min) {
                min = num;
                sign = 1;
            }
        }
        return sign * min;
    }

    public static int absMax(int[] nums) {
        int max = 0;
        int sign = 1;
        for (int num : nums) {
            if (num < 0 && -num > max) {
                max = -num;
                sign = -1;
            } else if (num >= 0 && num > max) {
                max = num;
                sign = 1;
            }
        }
        return sign * max;
    }
}
