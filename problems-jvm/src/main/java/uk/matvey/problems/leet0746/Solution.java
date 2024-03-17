package uk.matvey.problems.leet0746;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 2];
        for (int i = cost.length - 1; i >= 0; i--) {
            dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
        }
        return Math.min(dp[0], dp[1]);
    }
}

class SolutionTest {

    @Test
    public void case1() {
        int[] cost = new int[]{10, 15, 20};

        int result = new Solution().minCostClimbingStairs(cost);

        assertThat(result).isEqualTo(15);
    }

    @Test
    public void case2() {
        int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        int result = new Solution().minCostClimbingStairs(cost);

        assertThat(result).isEqualTo(6);
    }
}
