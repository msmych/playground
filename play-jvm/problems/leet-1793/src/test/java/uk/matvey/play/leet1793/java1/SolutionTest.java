package uk.matvey.play.leet1793.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var nums = new int[]{1, 4, 3, 7, 4, 5};

        int result = new Solution().maximumScore(nums, 3);

        assertThat(result).isEqualTo(15);
    }

    @Test
    public void case2() {
        var nums = new int[]{5, 5, 4, 5, 4, 1, 1, 1};

        int result = new Solution().maximumScore(nums, 0);

        assertThat(result).isEqualTo(20);
    }
}
