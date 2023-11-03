package uk.matvey.play.leet2917.java1;

import java.util.Arrays;

public class Solution {
    public int findKOr(int[] nums, int k) {
        int kor = 0;
        int max = Arrays.stream(nums).max().orElse(0);
        for (long bit = 1; bit <= max; bit *= 2) {
            int b = (int) bit;
            int count = (int) Arrays.stream(nums).filter(n -> (n & b) > 0).count();
            if (count >= k) {
                kor |= b;
            }
        }
        return kor;
    }
}
