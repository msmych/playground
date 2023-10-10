package uk.matvey.play.leet2896.java1;

import java.util.ArrayList;

public class Solution {
    public int minOperations(String s1, String s2, int x) {
        var diffs = new ArrayList<Integer>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffs.add(i);
            }
        }
        if (diffs.size() % 2 == 1) {
            return -1;
        }
        var dp = new int[diffs.size() + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = x + dp[i - 1];
            if (i >= 2) {
                dp[i] = Math.min(dp[i], 2 * (diffs.get(i - 1) - diffs.get(i - 2)) + dp[i - 2]);
            }
        }
        return dp[diffs.size()] / 2;
    }
}
