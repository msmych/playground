package uk.matvey.play.leet0931.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var matrix = new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};

        int result = new Solution().minFallingPathSum(matrix);

        assertThat(result).isEqualTo(13);
    }

    @Test
    public void case2() {
        var matrix = new int[][]{{-19, 57}, {-40, -5}};

        int result = new Solution().minFallingPathSum(matrix);

        assertThat(result).isEqualTo(-59);
    }
}
