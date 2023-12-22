package uk.matvey.play.leet1422.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        assertThat(new Solution().maxScore("00111")).isEqualTo(5);
    }

    @Test
    public void case2() {
        assertThat(new Solution().maxScore("1111")).isEqualTo(3);
    }
}
