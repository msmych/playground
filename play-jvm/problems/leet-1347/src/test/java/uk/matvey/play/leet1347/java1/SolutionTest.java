package uk.matvey.play.leet1347.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().minSteps("bab", "aba");

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case2() {
        int result = new Solution().minSteps("leetcode", "practice");

        assertThat(result).isEqualTo(5);
    }

    @Test
    public void case3() {
        int result = new Solution().minSteps("anagram", "mangaar");

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void case4() {
        int result = new Solution().minSteps("xxyyzz", "xxyyzz");

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void case5() {
        int result = new Solution().minSteps("friend", "family");

        assertThat(result).isEqualTo(4);
    }
}
