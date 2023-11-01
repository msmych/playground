package uk.matvey.play.leet0076.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        String result = new Solution().minWindow("ADOBECODEBANC", "ABC");

        assertThat(result).isEqualTo("BANC");
    }

    @Test
    public void case2() {
        String result = new Solution().minWindow("a", "a");

        assertThat(result).isEqualTo("a");
    }

    @Test
    public void case3() {
        String result = new Solution().minWindow("a", "aa");

        assertThat(result).isEqualTo("");
    }
}
