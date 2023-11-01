package uk.matvey.play.leet0003.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().lengthOfLongestSubstring("abcabcbb");

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case2() {
        int result = new Solution().lengthOfLongestSubstring("bbbbb");

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case3() {
        int result = new Solution().lengthOfLongestSubstring("pwwkew");

        assertThat(result).isEqualTo(3);
    }
}
