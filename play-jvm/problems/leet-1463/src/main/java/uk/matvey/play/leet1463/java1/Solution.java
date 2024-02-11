package uk.matvey.play.leet1463.java1;

public class Solution {

    public int cherryPickup(int[][] grid) {
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;
        var dp = new int[n][m][m];
        dp[0][0][m - 1] = grid[0][0] + grid[0][m - 1];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    if (j > i || j > k || k < m - i - 1) {
                        continue;
                    }
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j - 1 >= 0) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - 1][k]);
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - 1][k - 1]);
                    }
                    if (j - 1 >= 0 && k + 1 < m) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - 1][k + 1]);
                    }
                    if (j + 1 < m) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j + 1][k]);
                    }
                    if (j + 1 < m && k - 1 >= 0) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j + 1][k - 1]);
                    }
                    if (j + 1 < m && k + 1 < m) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j + 1][k + 1]);
                    }
                    if (k - 1 >= 0) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k - 1]);
                    }
                    if (k + 1 < m) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k + 1]);
                    }
                    if (j != k) {
                        dp[i][j][k] += grid[i][j] + grid[i][k];
                    } else {
                        dp[i][j][k] += grid[i][j];
                    }
                    if (dp[i][j][k] > count) {
                        count = dp[i][j][k];
                    }
                }
            }
        }

        return count;
    }
}
