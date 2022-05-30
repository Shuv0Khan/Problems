package leetcode.Algorithms;

/**
 * https://leetcode.com/problems/reverse-string/
 *
 * Write a function that reverses a string. The input string is given as an array of characters s.
 *
 * You must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^5
 * s[i] is a printable ascii character.
 */
public class ReverseString {
    public static void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char temp = s[j];
            s[j] = s[i];
            s[i] = temp;
        }
    }
}
