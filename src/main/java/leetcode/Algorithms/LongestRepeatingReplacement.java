package leetcode.Algorithms;

/**
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 *
 * You are given a string s and an integer k. You can choose any
 * character of the string and change it to any other uppercase
 * English character. You can perform this operation at most k times.
 *
 * Return the length of the longest substring containing the
 * same letter you can get after performing the above operations.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 * Example 2:
 *
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 10^5
 * s consists of only uppercase English letters.
 * 0 <= k <= s.length
 */
public class LongestRepeatingReplacement {
    /**
     * https://leetcode.com/problems/longest-repeating-character-replacement/solutions/91271/java-12-lines-o-n-sliding-window-solution-with-explanation/?envType=study-plan&id=level-1
     *
     * the problem can be reiterated as :
     * "longest substring where (length - max occurrence) <= k"
     * The key point is we are focusing on "longest".
     * So assume we initially found a valid substring, what do we do next?
     *
     * 1. Still valid even appended by one more char——then we are happy, just expand the window
     *
     * 2. It became invalid. But at this time, do we have to shrink the window?
     *      ——No, we shift the whole window rightwards by one unit.
     *      So that the length is unchanged.
     *      The reason for that is , any index smaller than original "start",
     *      will never have the chance to lead a longer valid substring than
     *      current length of our window.
     *
     * 3. Do we need to update max in time?
     *      ——No. Once again, we focus on "longest". The length of valid
     *      substring is determined by what?
     *      Max Occurrence + k
     *      We only need to update max occurrence when it becomes larger,
     *      because only that can we generate a longer valid substring.
     *
     *      If we can't surpass the historic max occurrence, then we can
     *      not generate a longer valid substring from current "start",
     *      I mean the new windows's left bound. To some extend,
     *      this becomes a game to find max occurrence.
     *
     *      Or , a better understanding is:
     *      "A game to eliminate inferior 'left bounds'.
     *
     * @param s
     * @param k
     * @return
     */
    public int characterReplacement(String s, int k) {
        int [] counts = new int[26];
        int historicalMaxCount = 0;
        int start = 0, end = 0;

        for (; end < s.length(); end++) {
            /*
             * shuvo - 2022-12-22, Thu, 12:52
             * maximum count of a character inside the window
             **/
            historicalMaxCount = Math.max(historicalMaxCount, ++counts[s.charAt(end) - 'A']);

            /*
             * shuvo - 2022-12-22, Thu, 12:52
             * length of window greater than last valid substring.
             * slide window forward without decreasing the length.
             **/
            if ((end - start + 1) > historicalMaxCount + k) {
                counts[s.charAt(start) - 'A']--;
                start++;
            }
        }
        return s.length() - start;
    }
}
