package uk.matvey.problems.leet1155;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    private static final int MOD = 1_000_000_007;

    public int numRollsToTarget(int n, int k, int target) {
        var dp = new int[n + 1][target + 1];
        for (int i = 1; i <= k && i <= target; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                for (int l = 1; l <= k && l < j; l++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - l]) % MOD;
                }
            }
        }
        return dp[n][target];
    }
}

class SolutionTest {

    @Test
    public void case1() {
        assertThat(new Solution().numRollsToTarget(1, 6, 3)).isEqualTo(1);
    }

    @Test
    public void case2() {
        assertThat(new Solution().numRollsToTarget(2, 6, 7)).isEqualTo(6);
    }

    @Test
    public void case3() {
        assertThat(new Solution().numRollsToTarget(30, 30, 500)).isEqualTo(222616187);
    }
}
