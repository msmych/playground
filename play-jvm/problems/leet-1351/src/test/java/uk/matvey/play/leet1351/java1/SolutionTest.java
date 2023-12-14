package uk.matvey.play.leet1351.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var grid = new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};

        int result = new Solution().countNegatives(grid);

        assertThat(result).isEqualTo(8);
    }

    @Test
    public void case2() {
        var grid = new int[][]{{3, 2}, {1, 0}};

        int result = new Solution().countNegatives(grid);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void case3() {
        var grid = new int[][]{{-1}};

        int result = new Solution().countNegatives(grid);

        assertThat(result).isEqualTo(1);
    }
}
