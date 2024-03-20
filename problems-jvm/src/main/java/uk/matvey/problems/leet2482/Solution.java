package uk.matvey.problems.leet2482;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        var rowOnes = new int[n];
        var colOnes = new int[m];
        var diff = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rowOnes[i] += grid[i][j];
                colOnes[j] += grid[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                diff[i][j] = 2 * rowOnes[i] - n + 2 * colOnes[j] - m;
            }
        }
        return diff;
    }
}

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
