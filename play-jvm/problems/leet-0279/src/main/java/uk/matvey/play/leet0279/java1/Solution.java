package uk.matvey.play.leet0279.java1;

import java.util.Arrays;

public class Solution {
    public int numSquares(int n) {
        var dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; i + j * j <= n; j++) {
                if (dp[i] + 1 < dp[i + j * j]) {
                    dp[i + j * j] = dp[i] + 1;
                }
            }
        }
        return dp[n];
    }
}
