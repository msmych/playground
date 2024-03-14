package uk.matvey.problems.leet0930;

import java.util.HashMap;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {

    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum = 0;
        var freq = new HashMap<Integer, Integer>();
        int count = 0;
        for (int num : nums) {
            sum += num;
            if (sum == goal) {
                count++;
            }
            count += freq.getOrDefault(sum - goal, 0);
            freq.merge(sum, 1, Integer::sum);
        }
        return count;
    }
}

class SolutionTest {

    @Test
    void case1() {
        final var nums = new int[]{1, 0, 1, 0, 1};

        final var result = new Solution().numSubarraysWithSum(nums, 2);

        assertThat(result).isEqualTo(4);
    }

    @Test
    void case2() {
        final var nums = new int[]{0, 0, 0, 0, 0};

        final var result = new Solution().numSubarraysWithSum(nums, 0);

        assertThat(result).isEqualTo(15);
    }

    @Test
    void case3() {
        final var nums = new int[]{0, 0, 0, 0, 0, 0, 1, 0, 0, 0};

        final var result = new Solution().numSubarraysWithSum(nums, 0);

        assertThat(result).isEqualTo(27);
    }
}
