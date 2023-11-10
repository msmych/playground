package uk.matvey.play.leet0115.java1;

import java.util.Arrays;

public class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        Arrays.fill(dp[0], 1);
        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                dp[i + 1][j + 1] = t.charAt(i) == s.charAt(j)
                    ? dp[i][j] + dp[i + 1][j] : dp[i + 1][j];
            }
        }
        return Arrays.stream(dp[dp.length - 1]).max().orElse(0);
    }
}
