package uk.matvey.play.leet0132.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().minCut("aab");

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case2() {
        int result = new Solution().minCut("a");

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void case3() {
        int result = new Solution().minCut("ab");

        assertThat(result).isEqualTo(1);
    }
}
