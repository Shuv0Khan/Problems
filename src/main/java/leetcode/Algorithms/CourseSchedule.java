package leetcode.Algorithms;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/course-schedule/description/
 *
 * There are a total of numCourses courses you have to take,
 * labeled from 0 to numCourses - 1. You are given an array
 * prerequisites where prerequisites[i] = [ai, bi] indicates
 * that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take
 * course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 *
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course
 * 0 you should also have finished course 1. So it is impossible.
 *
 * Constraints:
 *
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * All the pairs prerequisites[i] are unique.
 */
public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            ArrayList<Integer> adjList = adj.computeIfAbsent(prerequisites[i][1], k->new ArrayList<>());
            adjList.add(prerequisites[i][0]);
        }
        int[] visited = new int[numCourses];
        int[] recVisited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (isCycleDFS(i, visited, recVisited, adj)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isCycleDFS(int v, int[] visited, int[] recVisited, HashMap<Integer, ArrayList<Integer>> adj) {
        if (recVisited[v] == 1) {
            return true;
        }
        if (visited[v] == 1) {
            return false;
        }
        visited[v] = 1;
        recVisited[v] = 1;
        ArrayList<Integer> adjList = adj.get(v);

        if (adjList != null) {
            for (int i = 0; i < adjList.size(); i++) {
                if (isCycleDFS(adjList.get(i), visited, recVisited, adj)) {
                    return true;
                }
            }
        }

        recVisited[v] = 0;
        return false;
    }
}
