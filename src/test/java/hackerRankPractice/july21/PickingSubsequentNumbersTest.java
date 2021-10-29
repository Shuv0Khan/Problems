package hackerRankPractice.july21;

import hackerRankPractice.july21.PickingSubsequentNumbers;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author shuvo
 * @since 04/07/2021
 *
 */
class PickingSubsequentNumbersTest {

    @Test
    @DisplayName("Test with different Series")
    void testWithDifferentSeries() {
        List<Integer> list = new ArrayList<>();

        /*
        * 1 to 10
        **/
        list.clear();

        for (int i=1; i<=10; i++) list.add(i);
        Assertions.assertEquals(2, PickingSubsequentNumbers.pickingNumbers(list));

        /*
        * 10 to 1
        **/
        list.clear();

        for (int i=10; i>=1; i--) list.add(i);
        Assertions.assertEquals(2, PickingSubsequentNumbers.pickingNumbers(list));

        /*
        * series of evens from 1 to 10
        **/
        list.clear();

        for (int i = 2; i <= 10; i+=2) list.add(i);
        Assertions.assertEquals(1, PickingSubsequentNumbers.pickingNumbers(list));

        /*
        * series of evens from 10 to 1
        **/
        list.clear();

        for (int i = 10; i > 1; i-=2) list.add(i);
        Assertions.assertEquals(1, PickingSubsequentNumbers.pickingNumbers(list));

        /*
        * fibonacci series
        **/
        list.clear();

        int prev = 1;
        int current = 1;
        list.add(prev);
        list.add(current);
        for (int i = 0; i < 10; i++) {
            int sum = prev + current;
            prev = current;
            current = sum;
            list.add(sum);
        }
        Assertions.assertEquals(3, PickingSubsequentNumbers.pickingNumbers(list));
    }

    @Test
    @DisplayName("Test with positive and negative ints")
    void testWithPositiveAndNegativeInts() {
        List<Integer> list = new ArrayList<>();


        int [] l = new int[]{1, 1, 2, 2, 1, 2, 1, 2};
        list.clear();

        for (int i=0; i<l.length; i++) list.add(l[i]);
        Assertions.assertEquals(8, PickingSubsequentNumbers.pickingNumbers(list));


        l = new int[]{1, 1, 2, 2, 4, 4, 4, 5, 5, 5};
        list.clear();

        for (int i=0; i<l.length; i++) list.add(l[i]);
        Assertions.assertEquals(6, PickingSubsequentNumbers.pickingNumbers(list));


        l = new int[]{-1, -1, -2, -2, -4, 4, 4, 5, 5, 5};
        list.clear();

        for (int i=0; i<l.length; i++) list.add(l[i]);
        Assertions.assertEquals(5, PickingSubsequentNumbers.pickingNumbers(list));


        l = new int[]{-1, -1, 0, -2, -3, 4, 4, -5, -5, -5};
        list.clear();

        for (int i=0; i<l.length; i++) list.add(l[i]);
        Assertions.assertEquals(3, PickingSubsequentNumbers.pickingNumbers(list));


        l = new int[]{1, 2, 2, 3, 3};
        list.clear();

        for (int i=0; i<l.length; i++) list.add(l[i]);
        Assertions.assertEquals(4, PickingSubsequentNumbers.pickingNumbers(list));


        l = new int[]{-1, -1, 0, 1};
        list.clear();

        for (int i=0; i<l.length; i++) list.add(l[i]);
        Assertions.assertEquals(3, PickingSubsequentNumbers.pickingNumbers(list));


        l = new int[]{1, 2, 2, 4, 8, 10, 9, 9, 10};
        list.clear();

        for (int i=0; i<l.length; i++) list.add(l[i]);
        Assertions.assertEquals(4, PickingSubsequentNumbers.pickingNumbers(list));

    }
}
