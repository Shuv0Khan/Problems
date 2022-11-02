package leetcode.Algorithms;

/**
 * https://leetcode.com/problems/is-subsequence/
 *
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string
 * by deleting some (can be none) of the characters without disturbing the relative
 * positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde"
 * while "aec" is not).
 *
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 *
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 *
 * Constraints:
 *
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * s and t consist only of lowercase English letters.
 */
public class IsSubsequence {
    public static boolean isSubsequence(String s, String t){
        int i = 0;
        for(int j = 0; i < s.length() && j < t.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }
        return s.length() == i;
    }
}
