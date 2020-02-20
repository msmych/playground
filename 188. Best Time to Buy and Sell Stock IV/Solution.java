import java.util.Objects;
import java.util.Map;
import java.util.HashMap;

import static java.lang.Math.max;

class Solution {

    private static class Profit {
        int i, k;
        boolean bought;

        Profit(int i, int k, boolean bought) {
            this.i = i;
            this.k = k;
            this.bought = bought;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Profit profit = (Profit) o;
            return i == profit.i &&
                k == profit.k &&
                bought == profit.bought;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, k, bought);
        }
    }
    
    private final Map<Profit, Integer> cache = new HashMap<>();
    
    private int[] prices;

    public int maxProfit(int k, int[] prices) {
        if (k >= prices.length) {
            if (prices.length == 0)
                return 0;
            int profit = 0, lastPrice = prices[0];
            for (int i = 1; i < prices.length; i++) {
                int price = prices[i];
                if (price > lastPrice)
                    profit += price - lastPrice;
                lastPrice = price;
            }
            return profit;
        }
        this.prices = prices;
        return nextProfit(new Profit(0, k, false));
    }

    private int nextProfit(Profit profit) {
        if (profit.i >= prices.length) {
            return 0;
        }
        if (profit.i == prices.length - 1) {
            return profit.bought ? prices[profit.i] : 0;
        }
        if (cache.containsKey(profit)) {
            return cache.get(profit);
        }
        int p;
        if (profit.k == 0) {
            if (profit.bought) {
                p = max(
                    nextProfit(new Profit(profit.i + 1, 0, true)),
                    prices[profit.i]);
            } else {
                p = 0;
            }
        } else {
            if (profit.bought) {
                p = max(
                    nextProfit(new Profit(profit.i + 1, profit.k, true)),
                    nextProfit(new Profit(profit.i + 1, profit.k, false)) + prices[profit.i]);
            } else {
                p = max(
                    nextProfit(new Profit(profit.i + 1, profit.k, false)),
                    nextProfit(new Profit(profit.i + 1, profit.k - 1, true)) - prices[profit.i]);
            }
        }
        cache.put(profit, p);
        return p;
    } 

    // java Solution.java "2" "[2,4,1]" "2" "2" "[3,2,6,5,0,3]" "7" 2 "[2,1,4,5,2,9,7]" 11
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 3) {
            String k = args[i], prices = args[i + 1], expected = args[i + 2];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: k = %s, prices = %s",
                new Solution().maxProfit(Integer.parseInt(k), array(prices)), expected, k, prices));
        }
    }

    private static int[] array(String s) {
        String[] elements = s.substring(1, s.length() - 1).replaceAll(" ", "").split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }
}
