package leetcode.Algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/isomorphic-strings
 *
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character
 * while preserving the order of characters. No two characters may map to
 * the same character, but a character may map to itself.
 *
 * Input: s = "egg", t = "add"
 * Output: true
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 *
 * Input: s = "paper", t = "title"
 * Output: true
 *
 * Constraints:
 *
 * 1 <= s.length <= 5 * 10^4
 * t.length == s.length
 * s and t consist of any valid ascii character.
 */
public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> replacements = new HashMap<>();
        HashMap<Character, Character> used = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char original = s.charAt(i);
            char match = t.charAt(i);

            Character replacement = replacements.get(original);
            if (replacement == null) {
                if (used.get(match) != null) {
                    return false;
                }

                replacements.put(original, match);
                used.put(match, original);

            } else if (replacement != match) {
                return false;
            }
        }
        return true;
    }

    /**
     * Approach 1: Character Mapping with Dictionary
     * @param s
     * @param t
     * @return
     */
    public static boolean leetcodeSolnOne(String s, String t) {
        int[] mappingDictStoT = new int[256];
        Arrays.fill(mappingDictStoT, -1);

        int[] mappingDictTtoS = new int[256];
        Arrays.fill(mappingDictTtoS, -1);

        for (int i = 0; i < s.length(); ++i) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // Case 1: No mapping exists in either of the dictionaries
            if (mappingDictStoT[c1] == -1 && mappingDictTtoS[c2] == -1) {
                mappingDictStoT[c1] = c2;
                mappingDictTtoS[c2] = c1;
            }

            // Case 2: Ether mapping doesn't exist in one of the dictionaries or Mapping exists and
            // it doesn't match in either of the dictionaries or both
            else if (!(mappingDictStoT[c1] == c2 && mappingDictTtoS[c2] == c1)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Approach 2: First occurence transformation
     *
     * For a string like paper, the transformed string will be 01034.
     * The character p occurs first at the index 0; so we replace future
     * occurrences of p with the index 0. Similar modifications are made
     * for the other characters. Now let's look at title. The transformed
     * string would be 01034 which is the same as that for paper.
     * This confirms the isomorphic nature of both the strings.
     * @param s
     * @param t
     * @return
     */
    public static boolean leetcodeSolnTwo(String s, String t) {
        return transformString(s).equals(transformString(t));
    }

    private static String transformString(String s) {
        Map<Character, Integer> indexMapping = new HashMap<>();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {
            char c1 = s.charAt(i);

            if (!indexMapping.containsKey(c1)) {
                indexMapping.put(c1, i);
            }

            builder.append(Integer.toString(indexMapping.get(c1)));
            builder.append(" ");
        }
        return builder.toString();
    }
}
