package uk.matvey.problems.leet1314;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Index.atIndex;

public class Solution {

    public int[][] matrixBlockSum(int[][] mat, int K) {
        var blockSums = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                int blockSum = 0;
                for (int bi = Math.max(0, i - K); bi <= Math.min(mat.length - 1, i + K); bi++) {
                    for (int bj = Math.max(0, j - K); bj <= Math.min(mat[i].length - 1, j + K); bj++) {
                        blockSum += mat[bi][bj];
                    }
                }
                blockSums[i][j] = blockSum;
            }
        }
        return blockSums;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var mat = new int[][]{
            {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        };

        int[][] result = new Solution().matrixBlockSum(mat, 1);

        assertThat(result)
            .contains(new int[]{12, 21, 16}, atIndex(0))
            .contains(new int[]{27, 45, 33}, atIndex(1))
            .contains(new int[]{24, 39, 28}, atIndex(2));
    }
}
