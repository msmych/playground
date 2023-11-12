package uk.matvey.play.leet0815.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var routes = new int[][]{{1, 2, 7}, {3, 6, 7}};

        var result = new Solution().numBusesToDestination(routes, 1, 6);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void case2() {
        var routes = new int[][]{{7, 12}, {4, 5, 15}, {6}, {15, 19}, {9, 12, 13}};

        var result = new Solution().numBusesToDestination(routes, 15, 12);

        assertThat(result).isEqualTo(-1);
    }
}
