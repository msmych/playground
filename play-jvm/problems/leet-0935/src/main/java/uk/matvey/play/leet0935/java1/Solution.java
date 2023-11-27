package uk.matvey.play.leet0935.java1;

public class Solution {

    private static final int MOD = 1_000_000_007;

    public int knightDialer(int n) {
        if (n <= 2) {
            return 10 * n;
        }
        long count = 20;
        for (; n > 2; n--) {
            count *= 2;
            count += 2;
            count %= MOD;
        }
        return (int) count;
    }
}
