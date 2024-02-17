package uk.matvey.play.leet0368.java1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) {
            return List.of();
        }
        Arrays.sort(nums);
        var arr = new int[nums.length];
        var parent = new int[nums.length];
        Arrays.fill(parent, -1);
        arr[0] = 1;
        var max = 0;
        var maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            arr[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (arr[j] + 1 > arr[i]) {
                        arr[i] = arr[j] + 1;
                        parent[i] = j;
                    }
                }
            }
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        var subset = new ArrayList<Integer>();
        for (int i = maxIndex; i >= 0; i = parent[i]) {
            subset.addFirst(nums[i]);
        }
        return subset;
    }
}
