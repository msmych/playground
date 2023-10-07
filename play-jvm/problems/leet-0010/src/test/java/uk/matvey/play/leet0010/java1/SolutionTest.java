package uk.matvey.play.leet0010.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void case1() {
        boolean result = new Solution().isMatch("aa", "a");

        assertThat(result).isFalse();
    }

    @Test
    public void case2() {
        boolean result = new Solution().isMatch("aa", "a*");

        assertThat(result).isTrue();
    }

    @Test
    public void case3() {
        boolean result = new Solution().isMatch("ab", ".*");

        assertThat(result).isTrue();
    }

    @Test
    public void case4() {
        boolean result = new Solution().isMatch("aab", "c*a*b");

        assertThat(result).isTrue();
    }

    @Test
    public void case5() {
        boolean result = new Solution().isMatch("mississippi", "mis*is*p*.");

        assertThat(result).isFalse();
    }
}
