package uk.matvey.problems.leet1403;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        var sub = new ArrayList<Integer>();
        var leftSum = 0;
        var rightSum = Arrays.stream(nums).sum();
        for (int i = nums.length - 1; leftSum <= rightSum; i--) {
            sub.add(nums[i]);
            leftSum += nums[i];
            rightSum -= nums[i];
        }
        return sub;
    }
}

class SolutionTest {

    @Test
    void case1() {
        final var nums = new int[]{4, 3, 10, 9, 8};

        final var result = new Solution().minSubsequence(nums);

        assertThat(result).containsExactly(10, 9);
    }

    @Test
    void case2() {
        final var nums = new int[]{4, 4, 7, 6, 7};

        final var result = new Solution().minSubsequence(nums);

        assertThat(result).containsExactly(7, 7, 6);
    }

    @Test
    void case3() {
        final var nums = new int[]{6};

        final var result = new Solution().minSubsequence(nums);

        assertThat(result).containsExactly(6);
    }
}