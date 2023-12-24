package uk.matvey.play.leet0137.java1;

import java.util.Arrays;

public class Solution {
    public int singleNumber(int[] nums) {
        return (int)
                ((3 * Arrays.stream(nums).distinct().mapToLong(num -> num).sum() -
                        Arrays.stream(nums).mapToLong(num -> num).sum()) / 2);
    }
}
