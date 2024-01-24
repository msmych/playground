package uk.matvey.play.leet0198.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var nums = new int[]{1, 2, 3, 1};

        final var result = new Solution().rob(nums);

        assertThat(result).isEqualTo(4);
    }

    @Test
    public void case2() {
        var nums = new int[]{2, 7, 9, 3, 1};

        final var result = new Solution().rob(nums);

        assertThat(result).isEqualTo(12);
    }
}
