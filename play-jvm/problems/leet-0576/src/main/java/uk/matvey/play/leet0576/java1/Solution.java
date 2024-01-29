package uk.matvey.play.leet0576.java1;

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
