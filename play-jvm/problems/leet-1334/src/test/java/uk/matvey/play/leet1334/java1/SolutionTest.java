package uk.matvey.play.leet1334.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var edges = new int[][]{{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};

        int result = new Solution().findTheCity(4, edges, 4);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case2() {
        var edges = new int[][]{{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}};

        int result = new Solution().findTheCity(5, edges, 2);

        assertThat(result).isEqualTo(0);
    }
}
