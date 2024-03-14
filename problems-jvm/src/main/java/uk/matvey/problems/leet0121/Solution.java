package uk.matvey.problems.leet0121;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

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

class SolutionTest {

    @Test
    public void case1() {
        var prices = new int[]{7, 1, 5, 3, 6, 4};

        int result = new Solution().maxProfit(prices);

        assertThat(result).isEqualTo(5);
    }

    @Test
    public void case2() {
        var prices = new int[]{7, 6, 4, 3, 1};

        int result = new Solution().maxProfit(prices);

        assertThat(result).isEqualTo(0);
    }
}
