package leetcode.Algorithms;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstrWtRepeat {

    /**
     * With extra O(n) space for hashmap
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        int maxLen = 0;
        int i = 0, j = 0;

        for (; j < c.length; j++) {
            if (map.get(c[j]) != null) {
                if (j - i > maxLen) {
                    maxLen = j - i;
                }
                int k = map.get(c[j]);
                for (; i <= k; i++) {
                    map.remove(c[i]);
                }
            }
            map.put(c[j], j);
        }

        if (j - i > maxLen) {
            maxLen = j - i;
        }
        return maxLen;
    }
}
