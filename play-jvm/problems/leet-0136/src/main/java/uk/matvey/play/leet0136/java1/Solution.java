package uk.matvey.play.leet0136.java1;

import java.util.Arrays;

public class Solution {
    public int singleNumber(int[] nums) {
        return 2 * Arrays.stream(nums).distinct().sum() - Arrays.stream(nums).sum();
    }
}
