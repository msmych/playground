package uk.matvey.problems.leet1438;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int longestSubarray(int[] nums, int limit) {
        if (Arrays.stream(nums).distinct().count() == 1) {
            return nums.length;
        }
        int max = 1;
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (i == j) {
                j++;
                continue;
            }
            var stats = Arrays.stream(nums, i, j + 1).summaryStatistics();
            if (Math.abs(stats.getMax() - stats.getMin()) <= limit) {
                if (j - i + 1 > max) {
                    max = j - i + 1;
                }
                j++;
            } else {
                i++;
            }
        }
        return max;
    }
}

class SolutionTest {

    @Test
    void case1() {
        var nums = new int[]{8, 2, 4, 7};

        int result = new Solution().longestSubarray(nums, 4);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case2() {
        var nums = new int[]{10, 1, 2, 4, 7, 2};

        int result = new Solution().longestSubarray(nums, 5);

        assertThat(result).isEqualTo(4);
    }

    @Test
    void case3() {
        var nums = new int[]{4, 2, 2, 2, 4, 4, 2, 2};

        int result = new Solution().longestSubarray(nums, 0);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void case4() {
        var nums = new int[]{4, 8, 5, 1, 7, 9};

        int result = new Solution().longestSubarray(nums, 6);

        assertThat(result).isEqualTo(3);
    }
}
