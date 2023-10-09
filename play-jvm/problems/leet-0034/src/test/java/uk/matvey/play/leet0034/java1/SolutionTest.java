package uk.matvey.play.leet0034.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var nums = new int[]{5, 7, 7, 8, 8, 10};

        int[] result = new Solution().searchRange(nums, 8);

        assertThat(result).containsExactly(3, 4);
    }

    @Test
    public void case2() {
        var nums = new int[]{5, 7, 7, 8, 8, 10};

        int[] result = new Solution().searchRange(nums, 6);

        assertThat(result).containsExactly(-1, -1);
    }
}
