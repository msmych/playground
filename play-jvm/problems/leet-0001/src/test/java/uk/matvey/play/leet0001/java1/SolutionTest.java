package uk.matvey.play.leet0001.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    public void case1() {
        var nums = new int[]{2, 7, 11, 15};

        int[] result = new Solution().twoSum(nums, 9);

        assertThat(result).containsExactly(0, 1);
    }
}
