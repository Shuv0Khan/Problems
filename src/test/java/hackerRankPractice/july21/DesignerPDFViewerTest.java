package hackerRankPractice.july21;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author shuvo
 * @since 11/07/2021
 *
 */
class DesignerPDFViewerTest {

    @Test
    @DisplayName("Test cases provided")
    void testCasesProvided() {
        List<Integer> h = Arrays.asList(1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7);

        String word = "torn";
        Assertions.assertEquals(20, DesignerPDFViewer.designerPdfViewer(h, word));

        word = "abc";
        Assertions.assertEquals(9, DesignerPDFViewer.designerPdfViewer(h, word));

        word = "zaba";
        Assertions.assertEquals(28, DesignerPDFViewer.designerPdfViewer(h, word));
    }

}
