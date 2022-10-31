package leetcode.Algorithms;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/permutation-in-string/
 *
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 * Constraints:
 *
 * 1 <= s1.length, s2.length <= 10^4
 * s1 and s2 consist of lowercase English letters.
 */
public class PermutationInString {
    /**
     * My try with hashmap and counting.
     * the count revert part is costly
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            Integer count = map.get(ch);
            if (count == null) map.put(ch, 1);
            else map.put(ch, count + 1);
        }

        int start = 0;
        int end = s1.length();
        int it = s2.length() - end + 1;

        for (int i = 0; i < it;) {
            boolean matched = true;
            start = i;
            end = start + s1.length();

            for (int j = start; j < end; j++) {
                Integer found = map.get(s2.charAt(j));
                if (found == null) {
                    matched = false;
                    end = j;
                    i = j + 1;
                    break;
                } else if (found == 0) {
                    matched = false;
                    end = j;
                    i++;
                    break;
                } else {
                    map.put(s2.charAt(j), found - 1);
                }
            }

            if (matched) {
                return true;
            }

            for (;start < end; start++) {
                Integer count = map.get(s2.charAt(start));
                map.put(s2.charAt(start), count + 1);
            }

        }

        return false;
    }

    /**
     * From discussion. good sliding window.
     * The main concept of sliding window is
     * not to go back outside the window
     * @param s1
     * @param s2
     */
    public static boolean checkInclusionV2(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            Integer found = map.get(ch);
            if (found == null) map.put(ch, 1);
            else map.put(ch, found + 1);
        }

        int matches = 0;
        int start = 0;
        for (int end = 0;end < s2.length(); end++) {
            char right = s2.charAt(end);
            Integer count = map.get(right);
            if (count != null) {
                count--;
                map.put(right, count);
                if (count == 0) {
                    matches++;
                }
            }

            if (matches == map.size()) {
                return true;
            }

            // when window is completely spread, start sliding the left pivot
            if (end >= s1.length() - 1) {
                char left = s2.charAt(start++);
                count = map.get(left);
                if (count != null) {
                    if (count == 0) matches--;
                    map.put(left, count + 1);
                }
            }
        }
        return false;
    }

}
