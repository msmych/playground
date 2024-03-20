package uk.matvey.problems.leet2742;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int paintWalls(int[] cost, int[] time) {
        int len = cost.length;
        var dp = new int[len + 1][len + 1];
        for (int i = 1; i < dp[len].length; i++) {
            dp[len][i] = 1_000_000_000;
        }
        for (int i = len - 1; i >= 0; i--) {
            for (int remain = 1; remain <= len; remain++) {
                int paint = cost[i] + dp[i + 1][Math.max(0, remain - 1 - time[i])];
                int dontPaint = dp[i + 1][remain];
                dp[i][remain] = Math.min(paint, dontPaint);
            }
        }
        return dp[0][len];
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var cost = new int[]{1, 2, 3, 2};
        var time = new int[]{1, 2, 3, 2};

        int result = new Solution().paintWalls(cost, time);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case2() {
        var cost = new int[]{2, 3, 4, 2};
        var time = new int[]{1, 1, 1, 1};

        int result = new Solution().paintWalls(cost, time);

        assertThat(result).isEqualTo(4);
    }
}
