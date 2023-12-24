package uk.matvey.play.leet0137.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var nums = new int[]{2, 2, 3, 2};

        final var result = new Solution().singleNumber(nums);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case2() {
        var nums = new int[]{0, 1, 0, 1, 0, 1, 99};

        final var result = new Solution().singleNumber(nums);

        assertThat(result).isEqualTo(99);
    }
}
