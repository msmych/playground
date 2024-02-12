package uk.matvey.play.leet0368.java1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var nums = new int[]{1, 2, 3};

        List<Integer> result = new Solution().largestDivisibleSubset(nums);

        assertThat(result).containsExactly(1, 2);
    }

    @Test
    public void case2() {
        var nums = new int[]{1, 2, 4, 8};

        List<Integer> result = new Solution().largestDivisibleSubset(nums);

        assertThat(result).containsExactly(1, 2, 4, 8);
    }

    @Test
    public void case3() {
        var nums = new int[]{2, 3, 8, 9, 27};

        List<Integer> result = new Solution().largestDivisibleSubset(nums);

        assertThat(result).containsExactly(3, 9, 27);
    }
}
