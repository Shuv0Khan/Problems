package gitTheAlgos.math;

import gitTheAlgos.math.AbsoluteMinMax;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AbsoluteMinMaxTest {
    @Test
    @DisplayName("basic checks")
    void basicChecks() {
        int []nums;

        nums = new int[]{0};
        Assertions.assertEquals(0, AbsoluteMinMax.absMin(nums));
        Assertions.assertEquals(0, AbsoluteMinMax.absMax(nums));

        nums = new int[]{10};
        Assertions.assertEquals(10, AbsoluteMinMax.absMin(nums));
        Assertions.assertEquals(10, AbsoluteMinMax.absMax(nums));

        nums = new int[]{-10};
        Assertions.assertEquals(-10, AbsoluteMinMax.absMin(nums));
        Assertions.assertEquals(-10, AbsoluteMinMax.absMax(nums));

        nums = new int[]{0, 1, -1, 2, -2};
        Assertions.assertEquals(0, AbsoluteMinMax.absMin(nums));
        Assertions.assertEquals(2, AbsoluteMinMax.absMax(nums));

        nums = new int[]{1, 2, 3, 4};
        Assertions.assertEquals(1, AbsoluteMinMax.absMin(nums));
        Assertions.assertEquals(4, AbsoluteMinMax.absMax(nums));

        nums = new int[]{-10, 2, 3, 4};
        Assertions.assertEquals(2, AbsoluteMinMax.absMin(nums));
        Assertions.assertEquals(-10, AbsoluteMinMax.absMax(nums));

        nums = new int[]{-10, 2, 3, 4, 20};
        Assertions.assertEquals(2, AbsoluteMinMax.absMin(nums));
        Assertions.assertEquals(20, AbsoluteMinMax.absMax(nums));

    }
}