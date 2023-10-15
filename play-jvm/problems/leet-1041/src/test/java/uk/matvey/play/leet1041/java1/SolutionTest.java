package uk.matvey.play.leet1041.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        boolean result = new Solution().isRobotBounded("GGLLGG");

        assertThat(result).isTrue();
    }

    @Test
    public void case2() {
        boolean result = new Solution().isRobotBounded("GG");

        assertThat(result).isFalse();
    }

    @Test
    public void case3() {
        boolean result = new Solution().isRobotBounded("GL");

        assertThat(result).isTrue();
    }
}
