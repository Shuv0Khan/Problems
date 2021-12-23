package gitTheAlgos.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DeterminantOfMatrixTest {

    @Test
    @DisplayName("basicTests")
    void basicTests() {
        double mat1[][];
        double mat2[][];

        mat1 = new double[][]{
                {1, 2, 1},
                {4, 8, 3}
        };

        double det1 = DeterminantOfMatrix.upperTriangularDet(mat1);
        assertEquals(-1, det1);


        mat1 = new double[][]{
                {1, 2, 1},
                {4, 8, 3},
                {-1, 6, -4}
        };
        det1 = DeterminantOfMatrix.upperTriangularDet(mat1);

        mat2 = new double[][]{
                {1, 2, 1},
                {4, 8, 3},
                {-1, 6, -4}
        };
        double det2 = DeterminantOfMatrix.getDecDet(mat2);

        assertEquals(det2, det1);


        mat1 = new double[][]{
                {3, 2, 0, -4},
                {1, -1, 2, 0},
                {0, -2, 3, 1},
                {-1, 2, -2, 3}
        };
        det1 = DeterminantOfMatrix.upperTriangularDet(mat1);

        mat2 = new double[][]{
                {3, 2, 0, -4},
                {1, -1, 2, 0},
                {0, -2, 3, 1},
                {-1, 2, -2, 3}
        };
        det2 = DeterminantOfMatrix.getDecDet(mat2);

        assertEquals(det2, det1);


        mat1 = new double[][]{
                {1, 2, 1},
                {4, 8, 3},
                {-1, -2, -4}
        };
        det1 = DeterminantOfMatrix.upperTriangularDet(mat1);

        mat2 = new double[][]{
                {1, 2, 1},
                {4, 8, 3},
                {-1, -2, -4}
        };
        det2 = DeterminantOfMatrix.getDecDet(mat2);

        assertEquals(det2, det1);
    }

    @Test
    @DisplayName("random tests")
    void randomTests() {
        Random rand = new Random();
        DecimalFormat df = new DecimalFormat("#.##");
        for (int i = 0; i < 10; i++) {
            int n = rand.nextInt(6);
            if (n < 0) {
                n = -n;
            } else if (n == 0) {
                n = 3;
            }
            double[][] mat1 = new double[n][n];
            double[][] mat2 = new double[n][n];
            double[][] mat3 = new double[n][n];

            for (int l = 0; l < n; l++) {
                for (int m = 0; m < n; m++) {
                    double num = rand.nextInt(1000)/100.0;
                    mat1[l][m] = num;
                    mat2[l][m] = num;
                    mat3[l][m] = num;
                }
            }

            double det1 = DeterminantOfMatrix.upperTriangularDet(mat1);
            double det2 = DeterminantOfMatrix.getDecDet(mat2);
            if (!df.format(det1).equals(df.format(det2))) {
                for (int l = 0; l < n; l++) {
                    for (int m = 0; m < n; m++) {
                        System.out.print(mat3[l][m]+"  ");
                    }
                    System.out.println("");
                }
                fail("Det - expected: "+det2+", actual: "+det1);
            }
        }
    }
}