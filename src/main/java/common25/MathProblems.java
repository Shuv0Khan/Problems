package common25;

import java.util.ArrayList;
import java.util.List;

/**
 * Source - https://www.educative.io/blog/microsoft-interview-coding-questions
 *
 * Learnings -
 * problem 16 -
 *      1. Think some more about it.
 */
public class MathProblems {
    public static ArrayList<ArrayList<Integer>> allSumCombinations(int target) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        sumCombs(target, 0, 1, output, result);
        return output;
    }

    private static void sumCombs(int target, int currentSum, int start,
           ArrayList<ArrayList<Integer>> output, ArrayList<Integer> result) {
        if (currentSum == target) {
            output.add((ArrayList<Integer>) result.clone());
        }
        for (int i = start; i < target; i++) {
            int tempSum = currentSum + i;
            if (tempSum <= target) {
                result.add(i);
                sumCombs(target, tempSum, i, output, result);
                result.remove(result.size() - 1);
            } else {
                return;
            }
        }
    }
}
