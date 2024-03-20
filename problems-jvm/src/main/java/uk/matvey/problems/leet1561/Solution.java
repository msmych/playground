package uk.matvey.problems.leet1561;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        var candies = 0;
        for (int i = piles.length - 2, b = 0; i > b; i -= 2, b++) {
            candies += piles[i];
        }
        return candies;
    }
}

class SolutionTest {

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
