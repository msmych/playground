package uk.matvey.problems.leet1390;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    private final Map<Integer, Integer> cache = new HashMap<>();

    public int sumFourDivisors(int[] nums) {
        return Arrays.stream(nums)
            .map(this::sum4)
            .sum();
    }

    private int sum4(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int div2 = 0;
        int div3 = 0;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                if (div2 == 0) {
                    div2 = i;
                } else if (div3 == 0) {
                    div3 = i;
                } else {
                    cache.put(n, 0);
                    return 0;
                }
            }
        }
        if (div3 > 0) {
            cache.put(n, 1 + div2 + div3 + n);
            return 1 + div2 + div3 + n;
        } else {
            cache.put(n, 0);
            return 0;
        }
    }
}
