package uk.matvey.play.leet0005.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        String result = new Solution().longestPalindrome("babad");

        assertThat(result).isEqualTo("bab");
    }

    @Test
    public void case2() {
        String result = new Solution().longestPalindrome("cbbd");

        assertThat(result).isEqualTo("bb");
    }

    @Test
    public void case3() {
        String result = new Solution().longestPalindrome("abbcccbbbcaaccbababcbcabca");

        assertThat(result).isEqualTo("bbcccbb");
    }
}
