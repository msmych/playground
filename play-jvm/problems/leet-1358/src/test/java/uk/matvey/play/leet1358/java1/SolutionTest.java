package uk.matvey.play.leet1358.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        final var result = new Solution().numberOfSubstrings("abcabc");

        assertThat(result).isEqualTo(10);
    }

    @Test
    public void case2() {
        final var result = new Solution().numberOfSubstrings("aaacb");

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case3() {
        final var result = new Solution().numberOfSubstrings("abc");

        assertThat(result).isEqualTo(1);
    }
}
