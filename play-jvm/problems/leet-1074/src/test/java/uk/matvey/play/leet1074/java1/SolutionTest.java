package uk.matvey.play.leet1074.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var matrix = new int[][]{{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};

        final var result = new Solution().numSubmatrixSumTarget(matrix, 0);

        assertThat(result).isEqualTo(4);
    }

    @Test
    public void case2() {
        var matrix = new int[][]{{1, -1}, {-1, 1}};

        final var result = new Solution().numSubmatrixSumTarget(matrix, 0);

        assertThat(result).isEqualTo(5);
    }

    @Test
    public void case3() {
        var matrix = new int[][]{{904}};

        final var result = new Solution().numSubmatrixSumTarget(matrix, 0);

        assertThat(result).isEqualTo(0);
    }
}
