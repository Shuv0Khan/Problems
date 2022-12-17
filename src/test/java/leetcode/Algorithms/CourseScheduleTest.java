package leetcode.Algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseScheduleTest {
    @Test
    @DisplayName("basic test")
    void basicTest() {
        int[][] p = new int[][]{{1, 0}, {2, 0}, {1, 2}};
        assertTrue(CourseSchedule.canFinish(3, p));

        p = new int[][]{{1, 0}, {2, 0},};
        assertTrue(CourseSchedule.canFinish(3, p));

        p = new int[][]{{1, 0}, {2, 1}, {3, 2}, {5, 4}, {4, 5}};
        assertFalse(CourseSchedule.canFinish(6, p));

        p = new int[][]{{0, 1}};
        assertTrue(CourseSchedule.canFinish(2, p));

        p = new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}};
        assertTrue(CourseSchedule.canFinish(5, p));

    }
}