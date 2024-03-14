package uk.matvey.problems.leet0123;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

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

class SolutionTest {

    @Test
    public void case1() {
        var prices = new int[]{3, 3, 5, 0, 0, 3, 1, 4};

        int result = new Solution().maxProfit(prices);

        assertThat(result).isEqualTo(6);
    }

    @Test
    public void case2() {
        var prices = new int[]{1, 2, 3, 4, 5};

        int result = new Solution().maxProfit(prices);

        assertThat(result).isEqualTo(4);
    }

    @Test
    public void case3() {
        var prices = new int[]{7, 6, 4, 3, 1};

        int result = new Solution().maxProfit(prices);

        assertThat(result).isEqualTo(0);
    }
}
