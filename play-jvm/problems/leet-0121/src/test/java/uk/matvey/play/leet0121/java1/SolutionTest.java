package uk.matvey.play.leet0121.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

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
