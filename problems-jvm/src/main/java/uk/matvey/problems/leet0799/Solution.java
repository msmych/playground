package uk.matvey.problems.leet0799;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public double champagneTower(int poured, int query_row, int query_glass) {
        var tower = new double[100][100];
        tower[0][0] = poured;
        for (int i = 0; i < query_row; i++) {
            for (int j = 0; j <= i; j++) {
                double flow = tower[i][j];
                if (flow > 1) {
                    tower[i + 1][j] += (flow - 1) / 2;
                    tower[i + 1][j + 1] += (flow - 1) / 2;
                }
            }
        }
        return Math.min(1, tower[query_row][query_glass]);
    }
}

class SolutionTest {

    @Test
    public void case1() {
        double result = new Solution().champagneTower(1, 1, 1);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void case2() {
        double result = new Solution().champagneTower(2, 1, 1);

        assertThat(result).isEqualTo(0.5);
    }

    @Test
    public void case3() {
        double result = new Solution().champagneTower(100000009, 33, 17);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case4() {
        double result = new Solution().champagneTower(7841, 99, 99);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void case7() {
        double result = new Solution().champagneTower(0, 0, 0);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void case8() {
        double result = new Solution().champagneTower(25, 6, 1);

        assertThat(result).isEqualTo(0.18750);
    }
}
