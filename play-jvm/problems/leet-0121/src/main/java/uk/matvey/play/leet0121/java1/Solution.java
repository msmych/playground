package uk.matvey.play.leet0121.java1;

public class Solution {

    public int maxProfit(int[] prices) {
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
