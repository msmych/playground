package uk.matvey.play.leet1043.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var arr = new int[]{1, 15, 7, 9, 2, 5, 10};

        final var result = new Solution().maxSumAfterPartitioning(arr, 3);

        assertThat(result).isEqualTo(84);
    }

    @Test
    public void case2() {
        var arr = new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3};

        final var result = new Solution().maxSumAfterPartitioning(arr, 4);

        assertThat(result).isEqualTo(83);
    }

    @Test
    public void case3() {
        var arr = new int[]{1};

        final var result = new Solution().maxSumAfterPartitioning(arr, 1);

        assertThat(result).isEqualTo(1);
    }
}
