package uk.matvey.play.leet2482.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void case1() {
        var grid = new int[][]{{0, 1, 1}, {1, 0, 1}, {0, 0, 1}};

        int[][] result = new Solution().onesMinusZeros(grid);

        assertThat(result)
                .isDeepEqualTo(new int[][]{{0, 0, 4}, {0, 0, 4}, {-2, -2, 2}});
    }

    @Test
    public void case2() {
        var grid = new int[][]{{1, 1, 1}, {1, 1, 1}};

        int[][] result = new Solution().onesMinusZeros(grid);

        assertThat(result)
                .isDeepEqualTo(new int[][]{{5, 5, 5}, {5, 5, 5}});
    }
}