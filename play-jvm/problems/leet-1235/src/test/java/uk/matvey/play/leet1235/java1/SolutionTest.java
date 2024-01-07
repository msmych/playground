package uk.matvey.play.leet1235.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var startTime = new int[]{1, 2, 3, 3};
        var endTime = new int[]{3, 4, 5, 6};
        var profit = new int[]{50, 10, 40, 70};

        final var result = new Solution().jobScheduling(startTime, endTime, profit);

        assertThat(result).isEqualTo(120);
    }

    @Test
    public void case2() {
        var startTime = new int[]{1, 2, 3, 4, 6};
        var endTime = new int[]{3, 5, 10, 6, 9};
        var profit = new int[]{20, 20, 100, 70, 60};

        final var result = new Solution().jobScheduling(startTime, endTime, profit);

        assertThat(result).isEqualTo(150);
    }

    @Test
    public void case3() {
        var startTime = new int[]{1, 1, 1};
        var endTime = new int[]{2, 3, 4};
        var profit = new int[]{5, 6, 4};

        final var result = new Solution().jobScheduling(startTime, endTime, profit);

        assertThat(result).isEqualTo(6);
    }
}
