package uk.matvey.play.leet0219.java1;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> window = IntStream.rangeClosed(0, k).mapToObj(i -> nums[i])
            .collect(Collectors.groupingBy(n -> n, Collectors.summingInt(n -> 1)));
        if (window.values().stream().anyMatch(n -> n > 1)) {
            return true;
        }
        for (int j = k + 1; j < nums.length; j++) {
            window.merge(nums[j - k - 1], -1, Integer::sum);
            window.merge(nums[j], 1, Integer::sum);
            if (window.get(nums[j]) > 1) {
                return true;
            }
        }
        return false;
    }
}
