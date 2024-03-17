package uk.matvey.problems.leet0198;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

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

class SolutionTest {

    @Test
    public void case1() {
        var nums = new int[]{1, 2, 3, 1};

        final var result = new Solution().rob(nums);

        assertThat(result).isEqualTo(4);
    }

    @Test
    public void case2() {
        var nums = new int[]{2, 7, 9, 3, 1};

        final var result = new Solution().rob(nums);

        assertThat(result).isEqualTo(12);
    }
}
