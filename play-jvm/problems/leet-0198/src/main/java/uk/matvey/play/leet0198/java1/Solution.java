package uk.matvey.play.leet0198.java1;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private final Map<Integer, Integer> cache = new HashMap<>();

    private int[] nums;

    public int rob(int[] nums) {
        this.nums = nums;
        return robNext(0);
    }

    private int robNext(int i) {
        if (i >= nums.length) {
            return 0;
        }
        if (i == nums.length - 1) {
            return nums[i];
        }
        if (cache.containsKey(i)) {
            return cache.get(i);
        }
        var max = Math.max(robNext(i + 1), nums[i] + robNext(i + 2));
        cache.put(i, max);
        return max;
    }
}
