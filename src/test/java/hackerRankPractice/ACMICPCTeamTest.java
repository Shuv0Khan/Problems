package hackerRankPractice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author shuvo
 * @since 10/07/2021
 *
 */
class ACMICPCTeamTest {

    @Test
    @DisplayName("Test cases provided")
    void testCasesProvided() {
        List<String> topic;
        List<Integer> result;

        topic = Arrays.asList("10101", "11110", "00010");
        result = Arrays.asList(5, 1);
        Assertions.assertEquals(result, ACMICPCTeam.acmTeam(topic));


        topic = Arrays.asList("10101", "11100", "11010", "00101");
        result = Arrays.asList(5, 2);
        Assertions.assertEquals(result, ACMICPCTeam.acmTeam(topic));


    }

    @Test
    @DisplayName("Test cases")
    void testCases() {
        List<String> topic;
        List<Integer> result;

        topic = Arrays.asList("00000", "00000", "00000");
        result = Arrays.asList(0, 3);
        Assertions.assertEquals(result, ACMICPCTeam.acmTeam(topic));

        topic = Arrays.asList("00001", "00000");
        result = Arrays.asList(1, 1);
        Assertions.assertEquals(result, ACMICPCTeam.acmTeam(topic));

        topic = Arrays.asList("00001", "00000", "00001");
        result = Arrays.asList(1, 3);
        Assertions.assertEquals(result, ACMICPCTeam.acmTeam(topic));

        topic = Arrays.asList("00001", "00000", "00010");
        result = Arrays.asList(2, 1);
        Assertions.assertEquals(result, ACMICPCTeam.acmTeam(topic));
    }
}
