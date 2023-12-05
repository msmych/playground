package uk.matvey.play.leet1314.java1;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var mat = new int[][]{
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        };

        int[][] result = new Solution().matrixBlockSum(mat, 1);

        assertThat(result)
                .contains(new int[]{12, 21, 16}, Index.atIndex(0))
                .contains(new int[]{27,45,33}, Index.atIndex(1))
                .contains(new int[]{24,39,28}, Index.atIndex(2));
    }
}
