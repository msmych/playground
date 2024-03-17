package uk.matvey.problems.leet0576;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    private static final int MOD = 1_000_000_007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        var dp = new int[m][n];
        dp[startRow][startColumn] = 1;
        int count = 0;
        for (int moves = 1; moves <= maxMove; moves++) {
            var step = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == m - 1) {
                        count += dp[i][j];
                        count %= MOD;
                    }
                    if (j == n - 1) {
                        count += dp[i][j];
                        count %= MOD;
                    }
                    if (i == 0) {
                        count += dp[i][j];
                        count %= MOD;
                    }
                    if (j == 0) {
                        count += dp[i][j];
                        count %= MOD;
                    }
                    step[i][j] = (
                        ((i > 0 ? dp[i - 1][j] : 0) + (i < m - 1 ? dp[i + 1][j] : 0)) % MOD +
                            ((j > 0 ? dp[i][j - 1] : 0) + (j < n - 1 ? dp[i][j + 1] : 0)) % MOD
                    );
                    step[i][j] %= MOD;
                }
            }
            dp = step;
        }
        return count;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().findPaths(2, 2, 2, 0, 0);

        assertThat(result).isEqualTo(6);
    }

    @Test
    public void case2() {
        int result = new Solution().findPaths(1, 3, 3, 0, 1);

        assertThat(result).isEqualTo(12);
    }

    @Test
    public void case3() {
        int result = new Solution().findPaths(8, 50, 23, 5, 26);

        assertThat(result).isEqualTo(914783380);
    }
}
