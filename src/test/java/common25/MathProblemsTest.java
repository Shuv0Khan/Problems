package common25;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MathProblemsTest {
    @Test
    @DisplayName("all sum combinations basic test")
    void allSumCombinationsBasicTest() {
        List<List<Integer>> output = new ArrayList<>();
        output.add(Arrays.asList(1, 1, 1, 1, 1));
        output.add(Arrays.asList(1, 1, 1, 2));
        output.add(Arrays.asList(1, 1, 3));
        output.add(Arrays.asList(1, 2, 2));
        output.add(Arrays.asList(1, 4));
        output.add(Arrays.asList(2, 3));

        ArrayList<ArrayList<Integer>> result = MathProblems.allSumCombinations(5);
        assertEquals(output.size(), result.size());

        for (int i = 0; i < output.size(); i++){
            List<Integer> out = output.get(i);
            List<Integer> res = result.get(i);
            assertArrayEquals(out.toArray(), res.toArray());
        }
    }
}