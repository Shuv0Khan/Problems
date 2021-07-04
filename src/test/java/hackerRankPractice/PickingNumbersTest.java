package hackerRankPractice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PickingNumbersTest {

    @Test
    @DisplayName("Test cases")
    void testCases() {
        List<Integer> list = new ArrayList<>();


        int [] l = new int[]{1, 1, 2, 2, 1, 2, 1, 2};
        list.clear();

        for (int i=0; i<l.length; i++) list.add(l[i]);
        Assertions.assertEquals(8, PickingNumbers.pickingNumbers(list));


        l = new int[]{1, 1, 2, 4, 5, 5, 1, 2};
        list.clear();

        for (int i=0; i<l.length; i++) list.add(l[i]);
        Assertions.assertEquals(5, PickingNumbers.pickingNumbers(list));


        l = new int[]{4, 6, 5, 3, 3, 1};
        list.clear();

        for (int i=0; i<l.length; i++) list.add(l[i]);
        Assertions.assertEquals(3, PickingNumbers.pickingNumbers(list));

    }
}
