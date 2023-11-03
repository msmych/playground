package uk.matvey.play.leet0239.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};

        int[] result = new Solution().maxSlidingWindow(nums, 3);

        assertThat(result).containsExactly(3, 3, 5, 5, 6, 7);
    }

    @Test
    public void case2() {
        var nums = new int[]{1};

        int[] result = new Solution().maxSlidingWindow(nums, 1);

        assertThat(result).containsExactly(1);
    }
}
