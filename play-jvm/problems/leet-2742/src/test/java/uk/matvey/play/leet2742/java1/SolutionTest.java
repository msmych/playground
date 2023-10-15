package uk.matvey.play.leet2742.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var cost = new int[]{1, 2, 3, 2};
        var time = new int[]{1, 2, 3, 2};

        int result = new Solution().paintWalls(cost, time);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case2() {
        var cost = new int[]{2, 3, 4, 2};
        var time = new int[]{1, 1, 1, 1};

        int result = new Solution().paintWalls(cost, time);

        assertThat(result).isEqualTo(4);
    }
}
