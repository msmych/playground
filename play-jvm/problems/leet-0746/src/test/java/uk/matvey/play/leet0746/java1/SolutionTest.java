package uk.matvey.play.leet0746.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        int[] cost = new int[]{10, 15, 20};

        int result = new Solution().minCostClimbingStairs(cost);

        assertThat(result).isEqualTo(15);
    }

    @Test
    public void case2() {
        int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        int result = new Solution().minCostClimbingStairs(cost);

        assertThat(result).isEqualTo(6);
    }
}
