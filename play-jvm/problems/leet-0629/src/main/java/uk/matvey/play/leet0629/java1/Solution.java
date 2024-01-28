package uk.matvey.play.leet0629.java1;

public class Solution {
    private static final int MOD = 1_000_000_007;

    public int kInversePairs(int n, int k) {
        var dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                int a = 0;
                for (int m = 0; m < Math.min(i, j + 1); m++) {
                    a += dp[i - 1][j - m];
                    a %= MOD;
                }
                dp[i][j] = a;
            }
        }
        return dp[n][k];
    }
}
