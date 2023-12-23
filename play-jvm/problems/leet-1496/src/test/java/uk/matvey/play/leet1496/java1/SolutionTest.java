package uk.matvey.play.leet1496.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        assertThat(new Solution().isPathCrossing("NES")).isFalse();
    }

    @Test
    public void case2() {
        assertThat(new Solution().isPathCrossing("NESWW")).isTrue();
    }
}
