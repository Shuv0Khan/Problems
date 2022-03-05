package common25;

import java.util.ArrayList;

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
}
