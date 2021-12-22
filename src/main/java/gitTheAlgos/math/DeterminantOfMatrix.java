package gitTheAlgos.math;

public class DeterminantOfMatrix {
    /*
     * shuvo - 2021-12-22, Wed, 14:25
     * Upper triangular matrix way of determinant calculation
     **/
    public static int upperTriangularDet(int mat[][]) {
        if (mat.length != mat[0].length) {
            /*
             * shuvo - 2021-12-22, Wed, 14:27
             * invalid - not a square mattrix
             **/
            return -1;
        }
        int det = 1;
        int multiplier = 1;

        for (int col = 0, n = mat.length; col < n - 1; col++) {
            if (mat[col][col] == 0) {
                /*
                 * find a row with non-zero element at col and swap rows
                 **/
                int i = col + 1;
                for (; i < n; i++) {
                    if (mat[i][col] != 0) {
                        /*
                         * found row with non-zero elem
                         **/
                        break;
                    }
                }
                if (i == n) {
                    /*
                     * no row with non-zero elem at col found. det is zero
                     **/
                    return 0;
                }
                swapRow(mat, i, col);
                /*
                 * det sign changes if row swapped
                 **/
                det = -det;
            }

            /*
             * shuvo - 2021-12-22, Wed, 14:56
             * Row(3) = Row(3) x Elem(column being made zero) - Row(column being made zero) x Elem(3,column being made zero)
             **/
            for (int row = col + 1; row < n; row++) {
                if (mat[row][col] == 0) {
                    /*
                     * already zeroed. no further change needed
                     **/
                    continue;
                }
                int multRow1 = mat[col][col];
                int multRow2 = mat[row][col];
                multiplier *= multRow1;

                for (int i = 0; i < n; i++) {
                    mat[row][i] = mat[row][i] * multRow1 - mat[col][i] * multRow2;
                }
            }
        }
        
        /*
         * shuvo - 2021-12-22, Wed, 14:55
         * multiply diagonal for final determinant
         **/
        for (int i = 0; i < mat.length; i++) {
            det = det * mat[i][i];
        }

        /*
         * divide by all the row multiplication done
         **/
        return det/multiplier;
    }

    private static void swapRow(int[][] mat, int row1, int row2) {
        for (int i = 0; i < mat.length; i++) {
            int t = mat[row1][i];
            mat[row1][i] = mat[row2][i];
            mat[row2][i] = t;
        }
    }

}
