package leetcode.Algorithms;

/**
 * https://leetcode.com/problems/flood-fill/
 *
 * An image is represented by an m x n integer grid image
 * where image[i][j] represents the pixel value of the image.
 * You are also given three integers sr, sc, and color.
 * You should perform a flood fill on the image starting from
 * the pixel image[sr][sc].
 * To perform a flood fill, consider the starting pixel, plus
 * any pixels connected 4-directionally to the starting pixel
 * of the same color as the starting pixel, plus any pixels
 * connected 4-directionally to those pixels (also with the
 * same color), and so on. Replace the color of all of the
 * aforementioned pixels with color.
 *
 * Return the modified image after performing the flood fill.
 *
 * Constraints:
 *
 * m == image.length
 * n == image[i].length
 * 1 <= m, n <= 50
 * 0 <= image[i][j], color < 2^16
 * 0 <= sr < m
 * 0 <= sc < n
 */
public class FloodFill {
    /**
     * Recursion causes stackoverflow
     * @param image
     * @param sr
     * @param sc
     * @param color
     * @return
     */
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        int curColor = image[sr][sc];
        image[sr][sc] = color;
        if (sr - 1 >= 0 && image[sr - 1][sc] == curColor) {
            floodFill(image, sr - 1, sc, color);
        }
        if (sr + 1 < image.length && image[sr + 1][sc] == curColor) {
            floodFill(image, sr + 1, sc, color);
        }
        if (sc - 1 >= 0 && image[sr][sc - 1] == curColor) {
            floodFill(image, sr, sc - 1, color);
        }
        if (sc + 1 < image[0].length && image[sr][sc + 1] == curColor) {
            floodFill(image, sr, sc + 1, color);
        }
        return image;
    }
}
