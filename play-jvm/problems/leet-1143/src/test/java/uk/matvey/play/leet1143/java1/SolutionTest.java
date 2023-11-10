package uk.matvey.play.leet1143.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().longestCommonSubsequence("abcde", "ace");

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case2() {
        int result = new Solution().longestCommonSubsequence("abc", "abc");

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case3() {
        int result = new Solution().longestCommonSubsequence("abc", "def");

        assertThat(result).isEqualTo(0);
    }
}
