import java.util.*;

import static java.lang.Math.*;

class Solution {

    private static class Profit {
        int i;
        boolean bought, cooldown;

        public Profit(int i, boolean bought, boolean cooldown) {
            this.i = i;
            this.bought = bought;
            this.cooldown = cooldown;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Profit profit = (Profit) o;
            return i == profit.i &&
            bought == profit.bought &&
            cooldown == profit.cooldown;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, bought, cooldown);
        }
    }

    private final Map<Profit, Integer> cache = new HashMap<>();

    private int[] prices;

    public int maxProfit(int[] prices) {
        this.prices = prices;
        return nextProfit(new Profit(0, false, false));
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
        if (profit.cooldown) {
            p = nextProfit(new Profit(profit.i + 1, false, false));
        } else {
            if (profit.bought) {
                p = max(nextProfit(new Profit(profit.i + 1, true, false)),
                    nextProfit(new Profit(profit.i + 1, false, true)) + prices[profit.i]);
            } else {
                p = max(nextProfit(new Profit(profit.i + 1, false, false)),
                    nextProfit(new Profit(profit.i + 1, true, false)) - prices[profit.i]);
            }
        }
        cache.put(profit, p);
        return p;
    }

    // java Solution.java "[1,2,3,0,2]" "3"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String prices = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: prices = %s",
                new Solution().maxProfit(array(prices)), expected, prices));
        }
    }

    private static int[] array(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new int[0];
        String[] elements = s.split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }
}
