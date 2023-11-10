package uk.matvey.play.leet1143.java1;

import java.util.Arrays;

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        var dp = new int[text1.length() + 1][text2.length() + 1];
        for (var i = 0; i < text1.length(); i++) {
            for (var j = 0; j < text2.length(); j++) {
                dp[i + 1][j + 1] = text1.charAt(i) == text2.charAt(j)
                    ? dp[i][j] + 1
                    : Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }
        return Arrays.stream(dp)
            .mapToInt(row -> Arrays.stream(row).max().orElse(0))
            .max().orElse(0);
    }
}
