package uk.matvey.play.leet0122.java1;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int profit = 0, lastPrice = prices[0];
        for (var i = 1; i < prices.length; i++) {
            var price = prices[i];
            if (price > lastPrice) {
                profit += price - lastPrice;
            }
            lastPrice = price;
        }
        return profit;
    }
}
