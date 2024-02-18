package uk.matvey.play.leet2402.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var meetings = new int[][]{{0, 10}, {1, 5}, {2, 7}, {3, 4}};

        final var result = new Solution().mostBooked(2, meetings);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void case2() {
        var meetings = new int[][]{{1, 20}, {2, 10}, {3, 5}, {4, 9}, {6, 8}};

        final var result = new Solution().mostBooked(3, meetings);

        assertThat(result).isEqualTo(1);
    }
}
