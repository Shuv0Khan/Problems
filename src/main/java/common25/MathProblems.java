package common25;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Source - https://www.educative.io/blog/microsoft-interview-coding-questions
 *
 * Learnings -
 * problem 16 -
 *      1. Think some more about it.
 */
public class MathProblems {
    /**
     * <b>16. Find all sum combinations
     * <br>
     * Problem Statement:</b> Given a positive integer, target,
     * print all possible combinations of positive integers
     * that sum up to the target number.
     * @param target the target sum
     * @return list of list containing all the sum combinations
     */
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

    /**
     * Print all possible permutations of n numbers from 1 to n
     * @param n
     */
    public static ArrayList<String> allPermutations(int n) {
        if (n == 1) {
            return new ArrayList<>(Arrays.asList("1"));
        }
        String s = "";
        for (int i = 1; i<=n;i++){
            s+=i;
        }
        ArrayList<String> permutations = new ArrayList<>();
        printAllPermutations(s, 0, permutations);
        return permutations;
    }

    private static void printAllPermutations(String a, int start, ArrayList<String> permutations) {
        if (start == a.length()-2) {
            permutations.add(a);
            char [] b = a.toCharArray();
            char ch = b[start];
            b[start] = b[start+1];
            b[start+1] = ch;
            permutations.add(new String(b));
            return;
        }

        String s = a;
        for (int i = start+1; i <= s.length(); i++) {
            printAllPermutations(s, start+1, permutations);
            if (i < s.length()) {
                char[] b = s.toCharArray();
                char ch = b[start];
                b[start] = b[i];
                b[i] = ch;
                s = new String(b);
            }
        }
    }

    public static String kthPermutation(int n, int k) {
        char[] a = new char[n];
        for (int i = 0; i < n; i++) {
            a[i] = Character.forDigit((i+1), 10);
        }
        return new String(getKthPerm(a, k));
    }

    private static char[] getKthPerm(char[] a, int k) {
        if (k == 1) {
            /*
             * 1 based indexing.
             **/
            return a;
        }
        int fact = 1;
        int upperLimit = 1;

        for (; fact*upperLimit < k; fact*=upperLimit, upperLimit++);

        int index = a.length - upperLimit;
        int increment = fact; // lowerLimit! => where lowerLimit! < k <= upperLimit!
        int i = 1;
        for (int j = index + 1; ; i+=increment, j++) {
            if (i + increment <= k) {
                char ch = a[index];
                a[index] = a[j];
                a[j] = ch;
            } else {
                break;
            }
        }
        return getKthPerm(a, k - i + 1);
    }

}
