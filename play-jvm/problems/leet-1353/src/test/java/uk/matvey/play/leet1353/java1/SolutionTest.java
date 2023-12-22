package uk.matvey.play.leet1353.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var events = new int[][]{{1, 2}, {2, 3}, {3, 4}};

        final var result = new Solution().maxEvents(events);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case2() {
        var events = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 2}};

        final var result = new Solution().maxEvents(events);

        assertThat(result).isEqualTo(4);
    }

    @Test
    public void case3() {
        var events = new int[][]{{1, 4}, {4, 4}, {2, 2}, {3, 4}, {1, 1}};

        final var result = new Solution().maxEvents(events);

        assertThat(result).isEqualTo(4);
    }

    @Test
    public void case4() {
        var events = new int[][]{{1, 100000}};

        final var result = new Solution().maxEvents(events);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case5() {
        var events = new int[][]{{1, 1}, {1, 2}, {1, 3}, {1, 4}, {1, 5}, {1, 6}, {1, 7}};

        final var result = new Solution().maxEvents(events);

        assertThat(result).isEqualTo(7);
    }

    @Test
    public void case6() {
        var events = new int[][]{{1, 3}, {1, 3}, {1, 3}, {3, 4}};

        final var result = new Solution().maxEvents(events);

        assertThat(result).isEqualTo(4);
    }

    @Test
    public void case7() {
        var events = new int[][]{{1, 2}, {1, 2}, {3, 3}, {1, 5}, {1, 5}};

        final var result = new Solution().maxEvents(events);

        assertThat(result).isEqualTo(5);
    }

    @Test
    public void case8() {
        var events = new int[][]{{1, 2}, {2, 2}, {3, 3}, {3, 4}, {3, 4}};

        final var result = new Solution().maxEvents(events);

        assertThat(result).isEqualTo(4);
    }

    @Test
    public void case9() {
        var events = new int[][]{{25, 26}, {19, 19}, {9, 13}, {16, 17}, {17, 18}, {20, 21}, {22, 25}, {11, 12}, {19, 23}, {7, 9}, {1, 1}, {21, 23}, {14, 14}, {4, 7}, {16, 16}, {24, 28}, {16, 18}, {4, 5}, {18, 20}, {16, 16}, {25, 26}};

        final var result = new Solution().maxEvents(events);

        assertThat(result).isEqualTo(19);
    }
}
