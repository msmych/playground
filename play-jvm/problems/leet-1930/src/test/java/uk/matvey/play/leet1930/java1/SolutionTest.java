package uk.matvey.play.leet1930.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().countPalindromicSubsequence("aabca");

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case2() {
        int result = new Solution().countPalindromicSubsequence("adc");

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void case3() {
        int result = new Solution().countPalindromicSubsequence("bbcbaba");

        assertThat(result).isEqualTo(4);
    }
}
