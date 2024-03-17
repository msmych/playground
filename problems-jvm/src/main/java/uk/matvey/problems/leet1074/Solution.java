package uk.matvey.problems.leet1074;

import java.util.HashMap;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int count = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            var sum = new int[m];
            for (int j = i; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    sum[k] += matrix[j][k];
                }
                count += step(sum, target);
            }
        }
        return count;
    }

    private int step(int[] nums, int target) {
        int count = 0;
        int sum = 0;
        var map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            sum += num;
            if (sum == target) {
                count++;
            }
            if (map.containsKey(sum - target)) {
                count += map.get(sum - target);
            }
            map.merge(sum, 1, Integer::sum);
        }
        return count;
    }
}

class SolutionTest {

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
