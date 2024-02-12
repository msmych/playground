package uk.matvey.play.leet0279.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        assertThat(new Solution().numSquares(12)).isEqualTo(3);
    }

    @Test
    public void case2() {
        assertThat(new Solution().numSquares(13)).isEqualTo(2);
    }
}
