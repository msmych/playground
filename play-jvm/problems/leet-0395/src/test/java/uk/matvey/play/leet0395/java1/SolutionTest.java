package uk.matvey.play.leet0395.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().longestSubstring("aaabb", 3);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case2() {
        int result = new Solution().longestSubstring("ababbc", 2);

        assertThat(result).isEqualTo(5);
    }
}
