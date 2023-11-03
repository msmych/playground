package uk.matvey.play.leet0220.java1;

import java.util.TreeSet;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Integer> window = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer floor = window.floor(nums[i] + valueDiff);
            if (floor != null && floor >= nums[i]) {
                return true;
            }
            Integer ceiling = window.ceiling(nums[i] - valueDiff);
            if (ceiling != null && ceiling <= nums[i]) {
                return true;
            }

            window.add(nums[i]);
            if (i >= indexDiff) {
                window.remove(nums[i - indexDiff]);
            }
        }
        return false;
    }
}
