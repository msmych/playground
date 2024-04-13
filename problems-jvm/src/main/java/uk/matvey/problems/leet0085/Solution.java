package uk.matvey.problems.leet0085;

import java.util.Stack;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        var histogram = new int[matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            histogram[i] = matrix[0][i] - '0';
        }
        int max = maxArea(histogram);
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                histogram[j] = matrix[i][j] == '0' ? 0 : histogram[j] + 1;
            }
            int area = maxArea(histogram);
            if (area > max) {
                max = area;
            }
        }
        return max;
    }

    private int maxArea(int[] histogram) {
        var stack = new Stack<Integer>();
        int max = 0;
        for (var i = 0; i <= histogram.length; i++) {
            int last = i == histogram.length ? -1 : histogram[i];
            while (!stack.isEmpty() && histogram[stack.peek()] > last) {
                int height = histogram[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = height * width;
                if (area > max) {
                    max = area;
                }
            }
            stack.push(i);
        }
        return max;
    }
}

class SolutionTest {

    @Test
    void case1() {
        var matrix = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};

        var result = new Solution().maximalRectangle(matrix);

        assertThat(result).isEqualTo(6);
    }
}