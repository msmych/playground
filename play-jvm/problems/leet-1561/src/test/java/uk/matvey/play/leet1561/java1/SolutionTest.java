package uk.matvey.play.leet1561.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var nums = new int[]{2, 4, 1, 2, 7, 8};

        int result = new Solution().maxCoins(nums);

        assertThat(result).isEqualTo(9);
    }

    @Test
    public void case2() {
        var nums = new int[]{2, 4, 5};

        int result = new Solution().maxCoins(nums);

        assertThat(result).isEqualTo(4);
    }

    @Test
    public void case3() {
        var nums = new int[]{9, 8, 7, 6, 5, 1, 2, 3, 4};

        int result = new Solution().maxCoins(nums);

        assertThat(result).isEqualTo(18);
    }
}
