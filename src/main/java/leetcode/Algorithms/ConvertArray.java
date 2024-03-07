package leetcode.Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions
 *
 */
public class ConvertArray {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> l = new ArrayList<>();
        l.add(new ArrayList<>());
        int[] counts = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (l.size() < counts[nums[i]] + 1) {
                l.add(new ArrayList<>());
            }
            l.get(counts[nums[i]]).add(nums[i]);
            counts[nums[i]]++;
        }

        return l;
    }
}
