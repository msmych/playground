package uk.matvey.play.leet0123.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

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
