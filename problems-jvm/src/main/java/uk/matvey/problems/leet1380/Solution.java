package uk.matvey.problems.leet1380;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public List<Integer> luckyNumbers(int[][] matrix) {
        var lucky = new ArrayList<Integer>();
        var minRows = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            minRows[i] = matrix[i][0];
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] < minRows[i]) {
                    minRows[i] = matrix[i][j];
                }
            }
        }
        var maxCols = new int[matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            maxCols[j] = matrix[0][j];
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] > maxCols[j]) {
                    maxCols[j] = matrix[i][j];
                }
            }
        }
        for (int min : minRows) {
            for (int max : maxCols) {
                if (min == max) {
                    lucky.add(max);
                }
            }
        }
        return lucky;
    }
}

class SolutionTest {

    @Test
    void case1() {
        var matrix = new int[][]{
            {3, 7, 8},
            {9, 11, 13},
            {15, 16, 17}
        };

        List<Integer> result = new Solution().luckyNumbers(matrix);

        assertThat(result).containsExactly(15);
    }

    @Test
    void case2() {
        var matrix = new int[][]{
            {1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}
        };

        List<Integer> result = new Solution().luckyNumbers(matrix);

        assertThat(result).containsExactly(12);
    }

    @Test
    void case3() {
        var matrix = new int[][]{
            {7, 8}, {1, 2}
        };

        List<Integer> result = new Solution().luckyNumbers(matrix);

        assertThat(result).containsExactly(7);
    }
}
