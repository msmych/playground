package uk.matvey.play.leet0931.java1;

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        var dp = new int[n + 1][m + 2];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 999_999;
            dp[i][m + 1] = 999_999;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i][j + 1], dp[i][j + 2])) + matrix[i][j];
            }
        }
        int min = dp[n][0];
        for (int j = 1; j <= m; j++) {
            if (dp[n][j] < min) {
                min = dp[n][j];
            }
        }
        return min;
    }
}
