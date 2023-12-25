package uk.matvey.play.leet0091.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        assertThat(new Solution().numDecodings("12")).isEqualTo(2);
    }

    @Test
    public void case2() {
        assertThat(new Solution().numDecodings("226")).isEqualTo(3);
    }

    @Test
    public void case3() {
        assertThat(new Solution().numDecodings("06")).isEqualTo(0);
    }
}
