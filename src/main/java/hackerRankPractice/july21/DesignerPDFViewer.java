package hackerRankPractice.july21;

import java.util.List;

/**
 * @author shuvo
 * @since 11/07/2021
 * https://www.hackerrank.com/challenges/designer-pdf-viewer/problem
 */
public class DesignerPDFViewer {

    /*
     * Complete the 'designerPdfViewer' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h
     *  2. STRING word
     */

    public static int designerPdfViewer(List<Integer> h, String word) {
        // Write your code here
        int maxHeight = 0;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            int index = word.charAt(i) - 'a';
            if (h.get(index) > maxHeight) {
                maxHeight = h.get(index);
            }
        }

        return maxHeight * len;
    }

}
