package uk.matvey.play.leet0123.java1;

import java.util.Arrays;

public class Solution {
    public int maxProfit(int[] prices) {
        var max = maxSingleProfit(prices);
        for (var i = 2; i < prices.length - 1; i++) {
            var profit = maxSingleProfit(Arrays.copyOf(prices, i)) + maxSingleProfit(Arrays.copyOfRange(prices, i, prices.length));
            if (profit > max) {
                max = profit;
            }
        }
        return max;
    }

    private int maxSingleProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int profit = 0, max = prices[prices.length - 1];
        for (var i = prices.length - 2; i >= 0; i--) {
            if (prices[i + 1] > max) {
                max = prices[i + 1];
            }
            if (max - prices[i] > profit) {
                profit = max - prices[i];
            }
        }
        return profit;
    }
}
