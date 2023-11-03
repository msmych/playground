package uk.matvey.play.leet0239.java1;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Set<Integer>> window = new TreeMap<>();
        IntStream.range(0, k).forEach(i -> {
            window.putIfAbsent(nums[i], new HashSet<>());
            window.get(nums[i]).add(i);
        });
        int[] maxSliding = new int[nums.length - k + 1];
        maxSliding[0] = window.lastKey();
        for (int right = k; right < nums.length; right++) {
            window.putIfAbsent(nums[right], new HashSet<>());
            window.get(nums[right]).add(right);
            int left = right - k + 1;
            window.get(nums[left - 1]).remove(left - 1);
            window.remove(nums[left - 1], new HashSet<Integer>());
            maxSliding[left] = window.lastKey();
        }
        return maxSliding;
    }
}
