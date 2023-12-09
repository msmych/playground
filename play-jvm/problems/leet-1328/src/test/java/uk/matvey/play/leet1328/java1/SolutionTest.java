package uk.matvey.play.leet1328.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        String result = new Solution().breakPalindrome("abccba");

        assertThat(result).isEqualTo("aaccba");
    }

    @Test
    public void case2() {
        String result = new Solution().breakPalindrome("a");

        assertThat(result).isEqualTo("");
    }

    @Test
    public void case3() {
        String result = new Solution().breakPalindrome("aa");

        assertThat(result).isEqualTo("ab");
    }

    @Test
    public void case4() {
        String result = new Solution().breakPalindrome("aba");

        assertThat(result).isEqualTo("abb");
    }
}
