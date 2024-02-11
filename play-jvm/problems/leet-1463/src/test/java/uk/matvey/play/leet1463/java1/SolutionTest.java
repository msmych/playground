package uk.matvey.play.leet1463.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var grid = new int[][]{{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}};

        final var result = new Solution().cherryPickup(grid);

        assertThat(result).isEqualTo(24);
    }

    @Test
    public void case2() {
        var grid = new int[][]{{1, 0, 0, 0, 0, 0, 1}, {2, 0, 0, 0, 0, 3, 0}, {2, 0, 9, 0, 0, 0, 0}, {0, 3, 0, 5, 4, 0, 0}, {1, 0, 2, 3, 0, 0, 6}};

        final var result = new Solution().cherryPickup(grid);

        assertThat(result).isEqualTo(28);
    }
}
