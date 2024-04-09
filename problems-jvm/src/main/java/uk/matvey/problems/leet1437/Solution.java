package uk.matvey.problems.leet1437;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public boolean kLengthApart(int[] nums, int k) {
        int lastOne = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (lastOne != -1 && i - lastOne - 1 < k) {
                    return false;
                } else {
                    lastOne = i;
                }
            }
        }
        return true;
    }
}

class SolutionTest {

    @Test
    void case1() {
        var nums = new int[]{1, 0, 0, 0, 1, 0, 0, 1};

        var result = new Solution().kLengthApart(nums, 2);

        assertThat(result).isTrue();
    }

    @Test
    void case2() {
        var nums = new int[]{1, 0, 0, 1, 0, 1};

        var result = new Solution().kLengthApart(nums, 2);

        assertThat(result).isFalse();
    }

    @Test
    void case3() {
        var nums = new int[]{1, 1, 1, 1, 1};

        var result = new Solution().kLengthApart(nums, 0);

        assertThat(result).isTrue();
    }

    @Test
    void case4() {
        var nums = new int[]{0, 1, 0, 1};

        var result = new Solution().kLengthApart(nums, 1);

        assertThat(result).isTrue();
    }
}
