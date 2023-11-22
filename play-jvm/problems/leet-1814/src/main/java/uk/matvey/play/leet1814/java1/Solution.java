package uk.matvey.play.leet1814.java1;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

    private static final int MOD = 1_000_000_007;

    public int countNicePairs(int[] nums) {
        Map<Integer, Long> goods = Arrays.stream(nums)
            .mapToObj(i -> i - Integer.parseInt(new StringBuffer(Integer.toString(i)).reverse().toString()))
            .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        return (int) goods.values().stream().mapToLong(i -> i * (i - 1) / 2 % MOD).sum() % MOD;
    }
}
