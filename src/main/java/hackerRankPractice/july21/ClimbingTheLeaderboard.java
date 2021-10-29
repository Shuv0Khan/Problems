package hackerRankPractice.july21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author shuvo
 * @since 05/07/2021
 * https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
 */
public class ClimbingTheLeaderboard {
    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */
    static int binarySearch(List<Integer> list, int element) {
        int first = 0, last = list.size() - 1;
        int mid = (first + last) / 2;

        while (first < last) {
            if (list.get(mid) > element) {
                first = mid + 1;
            } else if (list.get(mid) < element) {
                last = mid - 1;
            } else {
                return mid;
            }
            mid = (first + last) / 2;
        }
        if (list.get(first) <= element) {
            return first;
        }
        return first + 1;
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        List<Integer> result = new ArrayList<>();

        HashMap<Integer, Integer> rankMap = new HashMap<>();
        for (int i = 0, rank = 1; i < ranked.size(); i++) {
            int score = ranked.get(i);
            if (rankMap.get(score) == null) {
                rankMap.put(score, rank);
                rank++;
            }
        }

        for (Integer score : player) {
            int index = binarySearch(ranked, score);
            if (index == ranked.size()) {
                result.add(rankMap.size() + 1);
                continue;
            }
            result.add(rankMap.get(ranked.get(index)));
        }

        return result;
    }

}
