package uk.matvey.play.leet1317.java1;

public class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            if (Integer.toString(i).contains("0") || Integer.toString(n - i).contains("0")) {
                continue;
            }
            return new int[]{i, n - i};
        }
        throw new IllegalArgumentException();
    }
}
