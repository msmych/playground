package uk.matvey.play.leet1316.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().distinctEchoSubstrings("abcabcabc");

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case2() {
        int result = new Solution().distinctEchoSubstrings("leetcodeleetcode");

        assertThat(result).isEqualTo(2);
    }
}
