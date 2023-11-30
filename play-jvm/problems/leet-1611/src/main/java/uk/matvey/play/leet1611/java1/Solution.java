package uk.matvey.play.leet1611.java1;

public class Solution {
    public int minimumOneBitOperations(int n) {
        if (n == 0) {
            return 0;
        }

        int k = 0;
        int i = 1;
        while (2 * i <= n) {
            i *= 2;
            k++;
        }
        return (1 << (k + 1)) - 1 - minimumOneBitOperations(n ^ i);
    }
}
