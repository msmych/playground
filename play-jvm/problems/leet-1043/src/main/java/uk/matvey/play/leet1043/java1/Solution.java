package uk.matvey.play.leet1043.java1;

public class Solution {

    public int maxSumAfterPartitioning(int[] arr, int k) {
        var dp = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            int max = arr[i];
            for (int j = i; j >= Math.max(0, i - k + 1); j--) {
                if (arr[j] > max) {
                    max = arr[j];
                }
                int sum = dp[j] + (i - j + 1) * max;
                if (sum > dp[i + 1]) {
                    dp[i + 1] = sum;
                }
            }
        }
        return dp[arr.length];
    }
}
