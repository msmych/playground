package uk.matvey.play.leet0122.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var prices = new int[]{7, 1, 5, 3, 6, 4};

        int result = new Solution().maxProfit(prices);

        assertThat(result).isEqualTo(7);
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
