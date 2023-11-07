package uk.matvey.play.leet1081.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        String result = new Solution().smallestSubsequence("cdadabcc");

        assertThat(result).isEqualTo("adbc");
    }

    @Test
    public void case2() {
        String result = new Solution().smallestSubsequence("abcd");

        assertThat(result).isEqualTo("abcd");
    }

    @Test
    public void case3() {
        String result = new Solution().smallestSubsequence("ecbacba");

        assertThat(result).isEqualTo("eacb");
    }

    @Test
    public void case4() {
        String result = new Solution().smallestSubsequence("leetcode");

        assertThat(result).isEqualTo("letcod");
    }
}
