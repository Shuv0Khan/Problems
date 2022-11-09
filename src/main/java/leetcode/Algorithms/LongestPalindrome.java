package leetcode.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        int longestLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int len = 0;
            for (int start = i, end = i + 1;
                 start > -1 && end < s.length() && s.charAt(start) == s.charAt(end);
                 start--, end++, len += 2);

            if (len > longestLength) {
                longestLength = len;
            }

            len = 1;
            for (int start = i - 1, end = i + 1;
                 start > -1 && end < s.length() && s.charAt(start) == s.charAt(end);
                 start--, end++, len += 2);

            if (len > longestLength) {
                longestLength = len;
            }
        }
        return longestLength;
    }
}
