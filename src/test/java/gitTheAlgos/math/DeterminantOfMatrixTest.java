package gitTheAlgos.math;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeterminantOfMatrixTest {

    @Test
    @DisplayName("basicTests")
    void basicTests() {
        int mat[][];

        mat = new int[][]{
                {1, 2, 1},
                {4, 8, 3}
        };

        int det = DeterminantOfMatrix.upperTriangularDet(mat);
        System.out.println(det);
        assertEquals(-1, det);

        mat = new int[][]{
                {1, 2, 1},
                {4, 8, 3},
                {-1, 6, -4}
        };

        det = DeterminantOfMatrix.upperTriangularDet(mat);
        System.out.println(det);
        assertEquals(8, det);

        mat = new int[][]{
                {3, 2, 0, -4},
                {1, -1, 2, 0},
                {0, -2, 3, 1},
                {-1, 2, -2, 3}
        };

        det = DeterminantOfMatrix.upperTriangularDet(mat);
        System.out.println(det);
        assertEquals(-15, det);

        mat = new int[][]{
                {1, 2, 1},
                {4, 8, 3},
                {-1, -2, -4}
        };

        det = DeterminantOfMatrix.upperTriangularDet(mat);
        System.out.println(det);
        assertEquals(0, det);
    }

}