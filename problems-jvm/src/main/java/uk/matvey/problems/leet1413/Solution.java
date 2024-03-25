package uk.matvey.problems.leet1413;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int minStartValue(int[] nums) {
        int initialValue = 1;
        for (int i = 0, value = initialValue; i < nums.length; i++) {
            value += nums[i];
            if (value < 1) {
                initialValue += 1 - value;
                value += 1 - value;
            }
        }
        return initialValue;
    }
}

class SolutionTest {

    @Test
    void case1() {
        var nums = new int[]{-3, 2, -3, 4, 2};

        int result = new Solution().minStartValue(nums);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void case2() {
        var nums = new int[]{1, 2};

        int result = new Solution().minStartValue(nums);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void case3() {
        var nums = new int[]{1, -2, -3};

        int result = new Solution().minStartValue(nums);

        assertThat(result).isEqualTo(5);
    }
}
