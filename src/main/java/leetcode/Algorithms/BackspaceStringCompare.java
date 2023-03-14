package leetcode.Algorithms;

import java.util.Stack;

/**
 * https://leetcode.com/problems/backspace-string-compare
 *
 * Given two strings s and t, return true if they are equal
 * when both are typed into empty text editors. '#' means a
 * backspace character.
 *
 * Note that after backspacing an empty text, the text will
 * continue empty.
 *
 *
 *
 * Example 1:
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 *
 * Example 2:
 * Input: s = "ab##", t = "c#d#"
 * Output: true
 * Explanation: Both s and t become "".
 *
 * Example 3:
 * Input: s = "a#c", t = "b"
 * Output: false
 * Explanation: s becomes "c" while t becomes "b".
 *
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 200
 * s and t only contain lowercase letters and '#' characters.
 *
 *
 * Follow up: Can you solve it in O(n) time and O(1) space?
 */
public class BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sourceStack = new Stack<>();
        Stack<Character> targetStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!sourceStack.isEmpty()) {
                    sourceStack.pop();
                }
            } else {
                sourceStack.push(s.charAt(i));
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#') {
                if (!targetStack.isEmpty()) {
                    targetStack.pop();
                }
            } else {
                targetStack.push(t.charAt(i));
            }
        }

        if (sourceStack.size() != targetStack.size()) {
            return false;
        }

        for (int i = 0, len = sourceStack.size(); i < len; i++) {
            if (sourceStack.pop() != targetStack.pop()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Follow up: Can you solve it in O(n) time and O(1) space?
     */
    public boolean backspaceCompareSol2(String s, String t) {
        int sPointer = s.length() - 1;
        int tPointer = t.length() - 1;
        int sHashCount = 0;
        int tHashCount = 0;

        while (sPointer >= 0 || tPointer >= 0) {
            // do all possible backspacing on s
            if (sPointer >= 0 && s.charAt(sPointer) == '#') {
                for (;sPointer >= 0 && s.charAt(sPointer) == '#'; sPointer--, sHashCount++);
                for (;sPointer >= 0 && s.charAt(sPointer) != '#' && sHashCount > 0; sPointer--, sHashCount--);
                continue;
            }

            // do all possible backspacing on t
            if (tPointer >=0 && t.charAt(tPointer) == '#') {
                for (;tPointer >= 0 && t.charAt(tPointer) == '#'; tPointer--, tHashCount++);
                for (;tPointer >= 0 && t.charAt(tPointer) != '#' && tHashCount > 0; tPointer--, tHashCount--);
                continue;
            }

            // if both became empty after backspacing, the while loop would've stopped
            // if only one of the strings is empty - fail
            if ((sPointer >= 0 && tPointer < 0) || (sPointer < 0 && tPointer >= 0)) {
                return false;
            }

            // both have chars to compare.
            if (s.charAt(sPointer) != t.charAt(tPointer)) {
                return false;
            }
            sPointer--;
            tPointer--;
        }

        return true;
    }
}
