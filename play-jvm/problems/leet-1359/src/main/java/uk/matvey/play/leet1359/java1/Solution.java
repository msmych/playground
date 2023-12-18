package uk.matvey.play.leet1359.java1;

public class Solution {
    public int countOrders(int n) {
        int mod = 1_000_000_007;
        long orders = 1;
        for (int i = 1; i <= n; i++) {
            orders = orders * (2 * i - 1) * i % mod;
        }
        return (int) orders;
    }
}
