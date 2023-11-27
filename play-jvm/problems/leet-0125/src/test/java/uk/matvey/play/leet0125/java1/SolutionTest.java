package uk.matvey.play.leet0125.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        boolean result = new Solution().isPalindrome("A man, a plan, a canal: Panama");

        assertThat(result).isTrue();
    }

    @Test
    public void case2() {
        boolean result = new Solution().isPalindrome("race a car");

        assertThat(result).isFalse();
    }
}
