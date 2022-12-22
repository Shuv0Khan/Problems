package leetcode.Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description
 *
 * Given two strings s and p, return an array of all the start
 * indices of p's anagrams in s. You may return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters
 * of a different word or phrase, typically using all the original
 * letters exactly once.
 *
 * Example 1:
 *
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 * Example 2:
 *
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 * Constraints:
 *
 * 1 <= s.length, p.length <= 3 * 10^4
 * s and p consist of lowercase English letters.
 */
public class FindAllAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new ArrayList<>();
        }

        List<Integer> indices = new ArrayList<>();

        // a-z total 26 characters
        int[] pCounts = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pCounts[p.charAt(i)-'a'] += 1;
        }

        // count and match the first p.length() characters
        int[] sCounts = new int[26];
        for (int i = 0; i < p.length(); i++) {
            sCounts[s.charAt(i) - 'a'] += 1;
        }

        if (isAnagram(sCounts, pCounts)) {
            indices.add(0);
        }

        for (int i = 1, j = p.length(); j < s.length(); i++, j++) {
            sCounts[s.charAt(i - 1) - 'a'] -= 1;
            sCounts[s.charAt(j) - 'a'] += 1;
            if (isAnagram(sCounts, pCounts)) {
                indices.add(i);
            }
        }

        return indices;
    }

    private static boolean isAnagram(int[] sCounts, int[] pCounts) {
        for (int i = 0; i < pCounts.length; i++) {
            if (sCounts[i] != pCounts[i]) {
                return false;
            }
        }
        return true;
    }
}
