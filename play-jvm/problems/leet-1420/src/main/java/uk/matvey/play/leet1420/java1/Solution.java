package uk.matvey.play.leet1420.java1;

class Solution {
    public int numOfArrays(int n, int m, int k) {
        var dp = new int[n + 1][m + 1][k + 1];
        int mod = 1_000_000_007;
        for (int i = 0; i <= m; i++) {
            dp[n][i][0] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int maxSoFar = m; maxSoFar >= 0; maxSoFar--) {
                for (int remain = 0; remain <= k; remain++) {
                    int ans = 0;
                    for (int num = 0; num < maxSoFar; num++) {
                        ans = (ans + dp[i + 1][maxSoFar][remain]) % mod;
                    }
                    if (remain > 0) {
                        for (int num = maxSoFar + 1; num <= m; num++) {
                            ans = (ans + dp[i + 1][num][remain - 1]) % mod;
                        }
                    }
                    dp[i][maxSoFar][remain] = ans;
                }
            }
        }
        return dp[0][0][k];
    }
}
