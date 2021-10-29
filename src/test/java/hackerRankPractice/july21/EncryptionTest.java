package hackerRankPractice.july21;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author shuvo
 * @since 12/07/2021
 *
 */
class EncryptionTest {

    @Test
    @DisplayName("Test cases provided")
    void testCasesProvided() {
        String s, enc;

        s = "if man was meant to stay on the ground god would have given us roots";
        enc = "imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau";
        Assertions.assertEquals(enc, Encryption.encryption(s));

        s = "haveaniceday";
        enc = "hae and via ecy";
        Assertions.assertEquals(enc, Encryption.encryption(s));

        s = "feedthedog    ";
        enc = "fto ehg ee dd";
        Assertions.assertEquals(enc, Encryption.encryption(s));

        s = "chillout";
        enc = "clu hlt io";
        Assertions.assertEquals(enc, Encryption.encryption(s));
    }
}
