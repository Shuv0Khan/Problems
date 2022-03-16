package common25;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    @Test
    @DisplayName("get all permutations")
    void getAllPermutations() {
        ArrayList<String> permutations = new ArrayList<>(Arrays.asList("1"));
        ArrayList<String> result = MathProblems.allPermutations(1);
        assertEquals(permutations.size(), result.size());
        for (int i = 0; i < permutations.size(); i++) {
            assertEquals(permutations.get(i), result.get(i));
        }

        permutations = new ArrayList<>(Arrays.asList("12", "21"));
        result = MathProblems.allPermutations(2);
        for (int i = 0; i < permutations.size(); i++) {
            assertEquals(permutations.get(i), result.get(i));
        }

        permutations = new ArrayList<>(Arrays.asList("123", "132", "213", "231", "312", "321"));
        result = MathProblems.allPermutations(3);
        for (int i = 0; i < permutations.size(); i++) {
            assertEquals(permutations.get(i), result.get(i));
        }


        permutations = new ArrayList<>(Arrays.asList(
                "1234", "1243", "1324", "1342", "1423", "1432",
                "2134", "2143", "2314", "2341", "2413", "2431",
                "3124", "3142", "3214", "3241", "3412", "3421",
                "4123", "4132", "4213", "4231", "4312", "4321"));
        result = MathProblems.allPermutations(4);
        for (int i = 0; i < permutations.size(); i++) {
            assertEquals(permutations.get(i), result.get(i));
        }
    }

    @Test
    @DisplayName("kth permutation basic test")
    void kthPermutationBasicTest() {
        int n = 4;
        ArrayList<String> permutations = new ArrayList<>(
            Arrays.asList(
                "1234", "1243", "1324", "1342", "1423", "1432",
                "2134", "2143", "2314", "2341", "2413", "2431",
                "3124", "3142", "3214", "3241", "3412", "3421",
                "4123", "4132", "4213", "4231", "4312", "4321"));

        for (int i = 0; i < permutations.size(); i++) {
            assertEquals(permutations.get(i), MathProblems.kthPermutation(n, i + 1));
        }
    }
}