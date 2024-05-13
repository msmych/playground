package uk.matvey.problems.leet0861;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int matrixScore(int[][] grid) {
        int score = (1 << (grid[0].length - 1)) * grid.length;
        for (int j = 1; j < grid[0].length; j++) {
            int count = 0;
            for (var row : grid) {
                count += row[j] == row[0] ? 1 : 0;
            }
            score += Math.max(count, grid.length - count) * (1 << (grid[0].length - 1 - j));
        }
        return score;
    }
}

class SolutionTest {

    @Test
    void case1() {
        var grid = new int[][]{
            {0, 0, 1, 1},
            {1, 0, 1, 0},
            {1, 1, 0, 0}
        };

        var result = new Solution().matrixScore(grid);

        assertThat(result).isEqualTo(39);
    }
}
