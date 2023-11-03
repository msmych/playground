package uk.matvey.play.leet0209.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var nums = new int[]{2, 3, 1, 2, 4, 3};

        int result = new Solution().minSubArrayLen(7, nums);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void case2() {
        var nums = new int[]{1, 4, 4};

        int result = new Solution().minSubArrayLen(4, nums);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case3() {
        var nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1};

        int result = new Solution().minSubArrayLen(11, nums);

        assertThat(result).isEqualTo(0);
    }
}
