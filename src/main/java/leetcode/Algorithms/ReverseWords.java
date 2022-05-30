package leetcode.Algorithms;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 *
 * Given a string s, reverse the order of characters in each word
 * within a sentence while still preserving whitespace and initial word order.
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 10^4
 * s contains printable ASCII characters.
 * s does not contain any leading or trailing spaces.
 * There is at least one word in s.
 * All the words in s are separated by a single space.
 */
public class ReverseWords {
    public static String reverseWords(String s) {
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == ' ') {
                String prev = s.substring(0, i);
                String word = s.substring(i, j);
                String next = s.substring(j);
                s = prev + reverse(word) + next;
                i = j + 1;
            }
        }
        String prev = s.substring(0, i);
        String word = s.substring(i);

        s = prev + reverse(word);
        return s;
    }

    private static String reverse(String s) {
        char[] word = s.toCharArray();

        for (int i = 0, j = word.length-1; i < j; i++, j--) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
        }
        return new String(word);
    }

    public static String reverseWordsV2(String s) {
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = reverse(words[i]);
        }
        return Arrays.stream(words).collect(Collectors.joining(" "));
    }
}
