import java.util.*;

class Solution {

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

    // java Solution.java "[3,3,5,0,0,3,1,4]" "6" "[1,2,3,4,5]" "4" "[7,6,4,3,1]" "0"
    public static void main(String... args) {
        for (int i = 0; i < args.length; i += 2) {
            String prices = args[i], expected = args[i + 1];
            System.out.println(String.format(
                "Output: %s | Expected: %s | Input: prices = %s",
                new Solution().maxProfit(intArr(prices)), expected, prices));
        }
    }

    private static int[] intArr(String s) {
        s = s.substring(1, s.length() - 1).replaceAll(" ", "");
        if (s.isEmpty()) return new int[0];
        String[] elements = s.split(",");
        int[] arr = new int[elements.length];
        for (int i = 0; i < elements.length; i++)
            arr[i] = Integer.parseInt(elements[i]);
        return arr;
    }
}
