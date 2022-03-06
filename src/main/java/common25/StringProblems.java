package common25;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Source - https://www.educative.io/blog/microsoft-interview-coding-questions
 *
 * Learnings -
 * Problem 10 -
 *      1. Beware of nested loops when using looping variables
 *      from the outer loop used in the inner loop.
 */
public class StringProblems {
    /**
     * <b>10. Reverse words in a sentence
     * <br>
     * Problem Statement:</b> Reverse the order of words in a given sentence.
     *<br>
     * Example: "sphinx of black quartz judge my vow" should
     * output as "vow my judge quartz black of sphinx"
     * <br><br>
     * <b>Solution with extra space</b>
     * @param sentence character array representing a string
     * @return word by word reverse of the sentence
     */
    public static char[] reverseSentenceByWordsWithExtraSpace(char[] sentence) {
        char[] reverse = new char[sentence.length];
        ArrayList<Integer> commaIndices = new ArrayList<>();
        commaIndices.add(-1);

        for (int i = 0; i < sentence.length; i++) {
            if (sentence[i] == ' ') {
                commaIndices.add(i);
            }
        }

        for (int i = commaIndices.size() - 1, j = sentence.length, k = 0; i > -1; i--) {
            for (int l = commaIndices.get(i)+1; l < j; l++, k++) {
                reverse[k] = sentence[l];
            }
            if (k < reverse.length) {
                reverse[k++] = ' ';
            }
            j = commaIndices.get(i);
        }
        return reverse;
    }

    /**
     * Better alternative to above. <b>No extra space required.</b>
     *
     * @param sentence character array representing a string
     * @return word by word reverse of the sentence
     */
    public static char[] reverseSentenceByWords(char[] sentence) {
        /*
         * shuvo - 2022-03-5, Sat, 11:31
         * reverse the full sentence
         **/
        for (int i = 0, j = sentence.length - 1; i < j; i++, j--) {
            char ch = sentence[i];
            sentence[i] = sentence[j];
            sentence[j] = ch;
        }

        /*
         * shuvo - 2022-03-5, Sat, 11:32
         * reverse only the words now
         **/
        for (int i = 0, j = 0; j < sentence.length; j++) {
            if (sentence[j] == ' ' || j == sentence.length - 1) {
                /*
                 * shuvo - 2022-03-5, Sat, 11:34
                 * reverse the word
                 **/
                if (sentence[j] != ' ' && j == sentence.length - 1) {
                    // for reversing last word if there is no space at the end.
                    j++;
                }
                for (int m = i, n = j - 1; m < n; m++, n--) {
                    char ch = sentence[m];
                    sentence[m] = sentence[n];
                    sentence[n] = ch;
                }
                i = j + 1;
            }
        }
        return sentence;
    }

    /**
     * <b>11. Find all palindrome substrings
     * <br>
     * Problem Statement:</b> Given a string, find all non-single letter substrings that are palindromes.
     *<br>
     * Example:
     *<br>
     * An string input of "poppopo" would return "pop", "opo", "oppo", "pp", and "poppop".
     * <br><br><b>Uses recursion to expand the tree</b>
     * @param s
     * @return
     */
    public static Set<String> recursiveFindPalindromeSubStrings(String s) {
        if (s == null || s.length() < 2){
            return new HashSet<>();
        }
        Set<String> palindromes = new HashSet<>();
        findPalindromes(s, 0, s.length(), palindromes);
        return palindromes;
    }

    private static void findPalindromes(String s, int start, int end, Set<String> palindromes) {
        addIfPalindrome(s, start, end, palindromes);

        if (end - start == 2) {
            return;
        }
        if (start == 0 || !palindromes.contains(s.substring(start-1, end -1))) {
            findPalindromes(s, start, end - 1, palindromes);
        }
        if (end == s.length()) {
            findPalindromes(s, start + 1, end, palindromes);
        }
    }

    private static void addIfPalindrome(String s, int start, int end, Set<String> palindromes) {
        int strLen = end - start;
        int i = strLen/2 + start;
        int j = 0;
        if (strLen % 2 == 0) {
            j = i + 1;
        } else {
            j = i + 2;
        }
        for (i--,j--; i > start-1 && j < end; i--, j++) {
            if (s.charAt(i) == s.charAt(j)) {
                palindromes.add(s.substring(i, j+1));
            }else {
                return;
            }
        }
    }

    public static Set<String> centerFindPalindromeSubStrings(String s) {
        Set<String> palindromes = new HashSet<>();
        for (int i = 0; i < s.length() - 1; i++) {
            expandAtCenter(s, i, i, palindromes);
            expandAtCenter(s, i, i + 1, palindromes);
        }
        return palindromes;
     }

    private static void expandAtCenter(String s, int left, int right, Set<String> palindromes) {
        /*
         * shuvo - 2022-03-5, Sat, 17:46
         * To avoid single letter palindromes
         **/
        if (left == right) {
            left--;
            right++;
        }
        for (; left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right); left--, right++) {
            palindromes.add(s.substring(left, right + 1));
        }
    }

    /**
     * <b>12. String segmentation
     * <br>
     * Problem Statement:</b> Given a dictionary of words and a large input string,
     * find whether or not the input string can be completely segmented
     * into the words of that dictionary.
     * @param s the string to segment
     * @param dict the list of possible words
     * @return true if full segmentation possible, false otherwise
     */
    public static boolean wordBreak(String s, List<String> dict) {
        Set<String> d = new HashSet<>(dict); // to remove O(n) check time for checking word

        int [] dp = new int[s.length()+1];
        dp[0] = 1;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] == 1 && d.contains(s.substring(j, i))) {
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[s.length()] == 1;
    }
}
