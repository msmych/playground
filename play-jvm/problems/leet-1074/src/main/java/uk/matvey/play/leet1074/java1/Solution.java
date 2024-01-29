package uk.matvey.play.leet1074.java1;

import java.util.HashMap;

public class Solution {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int count = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            var sum = new int[m];
            for (int j = i; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    sum[k] += matrix[j][k];
                }
                count += step(sum, target);
            }
        }
        return count;
    }

    private int step(int[] nums, int target) {
        int count = 0;
        int sum = 0;
        var map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            sum += num;
            if (sum == target) {
                count++;
            }
            if (map.containsKey(sum - target)) {
                count += map.get(sum - target);
            }
            map.merge(sum, 1, Integer::sum);
        }
        return count;
    }
}
