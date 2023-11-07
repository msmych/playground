package uk.matvey.play.leet1044.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        String result = new Solution().longestDupSubstring("banana");

        assertThat(result).isEqualTo("ana");
    }

    @Test
    public void case2() {
        String result = new Solution().longestDupSubstring("abcd");

        assertThat(result).isEqualTo("");
    }
}
