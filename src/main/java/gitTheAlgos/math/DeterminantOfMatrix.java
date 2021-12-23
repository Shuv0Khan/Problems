package gitTheAlgos.math;

public class DeterminantOfMatrix {
    /**
     * shuvo - 2021-12-22, Wed, 14:25
     * Upper triangular matrix way of determinant calculation
     *
     * Learning -
     * 1. Upper and Lower triangular matrices. A = LU. LU Decomposition, Bareiss Algorithm, Laplace Expansion.
     * 2. Row operation - if for a matrix A, we do -> R3 = a.R3 - b.R1 to get matrix B then, det(A) = 1/a det(B)
     */
    public static double upperTriangularDet(double mat[][]) {
        if (mat.length != mat[0].length) {
            /*
             * shuvo - 2021-12-22, Wed, 14:27
             * invalid - not a square mattrix
             **/
            return -1;
        }
        double det = 1;
        double multiplier = 1;

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
                double multRow1 = mat[col][col];
                double multRow2 = mat[row][col];
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

    private static void swapRow(double[][] mat, int row1, int row2) {
        for (int i = 0; i < mat.length; i++) {
            double t = mat[row1][i];
            mat[row1][i] = mat[row2][i];
            mat[row2][i] = t;
        }
    }

    /**
     * source - http://sandsduchon.org/duchon/math/determinantJava.html
     * @param a - matrix
     * @return determinant
     */
    public static double getDecDet (double [][] a) {
        int n = a.length - 1;
        if (n < 0) return 0;
        double M [][][] = new double [n+1][][];

        M[n] = a;  // init first, largest, M to a

        // create working arrays
        for (int i = 0; i < n; i++)
            M[i] = new double [i+1][i+1];

        return getDecDet (M, n);
    } // end method getDecDet double [][] parameter

    private static double getDecDet (double [][][] M, int m) {
        if (m == 0) return M[0][0][0];
        int e = 1;

        // init subarray to upper left mxm submatrix
        for (int i = 0; i < m; i++)
            for (int j = 0; j < m; j++)
                M[m-1][i][j] = M[m][i][j];
        double sum = M[m][m][m] * getDecDet (M, m-1);

        // walk through rest of rows of M
        for (int i = m-1; i >= 0; i--) {
            for (int j = 0; j < m; j++)
                M[m-1][i][j] = M[m][i+1][j];
            e = -e;
            sum += e * M[m][i][m] * getDecDet (M, m-1);
        } // end for each row of matrix

        return sum;
    } // end getDecDet double [][][], int
}
