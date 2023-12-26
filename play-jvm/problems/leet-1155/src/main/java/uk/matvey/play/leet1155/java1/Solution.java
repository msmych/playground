package uk.matvey.play.leet1155.java1;

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
