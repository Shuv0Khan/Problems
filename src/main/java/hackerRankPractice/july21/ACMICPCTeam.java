package hackerRankPractice.july21;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shuvo
 * @since 10/07/2021
 * https://www.hackerrank.com/challenges/acm-icpc-team/problem?h_r=next-challenge&h_v=zen
 */
public class ACMICPCTeam {
    public static int sum(String topic1, String topic2) {
        int sum = 0;
        for (int i = 0; i < topic1.length(); i++) {
            if (topic1.charAt(i) == '1' || topic2.charAt(i) == '1') {
                sum++;
            }
        }
        return sum;
    }
    /*
     * Complete the 'acmTeam' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY topic as parameter.
     */

    public static List<Integer> acmTeam(List<String> topic) {
        // Write your code here
        List<Integer> result = new ArrayList<>();

        int maxTopics = -1, maxTeams = -1;

        for (int i = 0; i < topic.size(); i++) {
            for (int j = i + 1; j < topic.size(); j++) {
                int topicsCovered = sum(topic.get(i), topic.get(j));
                if (topicsCovered == maxTopics) {
                    maxTeams++;
                } else if (topicsCovered > maxTopics) {
                    maxTopics = topicsCovered;
                    maxTeams = 1;
                }
            }
        }

        result.add(maxTopics);
        result.add(maxTeams);

        return result;

    }
}
