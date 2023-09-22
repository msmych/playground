package uk.matvey.leet.problem2860.java1;

import java.util.List;

class Solution {
    public int countWays(List<Integer> nums) {
        var sortedNums = nums.stream().sorted().toList();
        var ways = sortedNums.get(0) == 0 ? 1 : 2;
        for (int count = 1; count < nums.size(); count++) {
            int maxSelected = sortedNums.get(count - 1);
            if (maxSelected >= count) {
                continue;
            }
            int minNotSelected = sortedNums.get(count);
            if (minNotSelected <= count) {
                continue;
            }
            ways++;
        }
        return ways;
    }
}
