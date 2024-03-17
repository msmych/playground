package uk.matvey.problems.leet0931;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        var dp = new int[n + 1][m + 2];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 999_999;
            dp[i][m + 1] = 999_999;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i][j + 1], dp[i][j + 2])) + matrix[i][j];
            }
        }
        int min = dp[n][0];
        for (int j = 1; j <= m; j++) {
            if (dp[n][j] < min) {
                min = dp[n][j];
            }
        }
        return min;
    }
}

class SolutionTest {

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
