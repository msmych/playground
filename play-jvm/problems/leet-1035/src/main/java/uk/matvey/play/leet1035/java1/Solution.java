package uk.matvey.play.leet1035.java1;

public class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        var dp = new int[A.length + 1][B.length + 1];
        for (var i = 1; i <= A.length; i++) {
            for (var j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[A.length][B.length];
    }
}
