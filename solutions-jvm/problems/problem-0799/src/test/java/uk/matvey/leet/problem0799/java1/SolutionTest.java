package uk.matvey.leet.problem0799.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
