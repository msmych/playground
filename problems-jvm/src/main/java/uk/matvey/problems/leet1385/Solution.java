package uk.matvey.problems.leet1385;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        return (int) Arrays.stream(arr1)
            .filter(a -> Arrays.stream(arr2)
                .allMatch(b -> Math.abs(b - a) > d))
            .count();
    }
}

class SolutionTest {

    @Test
    void case1() {
        int result = new Solution().findTheDistanceValue(new int[]{4, 5, 8}, new int[]{10, 9, 1, 8}, 2);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case2() {
        int result = new Solution().findTheDistanceValue(new int[]{1, 4, 2, 3}, new int[]{-4, -3, 6, 10, 20, 30}, 3);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void case3() {
        int result = new Solution().findTheDistanceValue(new int[]{2, 1, 100, 3}, new int[]{-5, -2, 10, -3, 7}, 6);

        assertThat(result).isEqualTo(1);
    }
}
