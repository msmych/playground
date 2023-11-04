package uk.matvey.play.leet1503.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var left = new int[]{4, 3};
        var right = new int[]{0, 1};

        int result = new Solution().getLastMoment(4, left, right);

        assertThat(result).isEqualTo(4);
    }

    @Test
    public void case2() {
        var left = new int[]{};
        var right = new int[]{0, 1, 2, 3, 4, 5, 6, 7};

        int result = new Solution().getLastMoment(7, left, right);

        assertThat(result).isEqualTo(7);
    }

    @Test
    public void case3() {
        var left = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        var right = new int[]{};

        int result = new Solution().getLastMoment(7, left, right);

        assertThat(result).isEqualTo(7);
    }
}
