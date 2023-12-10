package uk.matvey.play.leet1332.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().removePalindromeSub("ababa");

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case2() {
        int result = new Solution().removePalindromeSub("abb");

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void case3() {
        int result = new Solution().removePalindromeSub("");

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void case4() {
        int result = new Solution().removePalindromeSub("ababb");

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void case5() {
        int result = new Solution().removePalindromeSub("baabaaaababbbbaabbabbbbaabbabbababaaababababbabbab");

        assertThat(result).isEqualTo(2);
    }
}
