package uk.matvey.play.leet1319.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var connections = new int[][]{{0, 1}, {0, 2}, {1, 2}};

        int result = new Solution().makeConnected(4, connections);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case2() {
        var connections = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}};

        int result = new Solution().makeConnected(6, connections);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void case3() {
        var connections = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 2}};

        int result = new Solution().makeConnected(6, connections);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    public void case4() {
        var connections = new int[][]{{0,1},{0,2},{3,4},{2,3}};

        int result = new Solution().makeConnected(5, connections);

        assertThat(result).isEqualTo(0);
    }
}
