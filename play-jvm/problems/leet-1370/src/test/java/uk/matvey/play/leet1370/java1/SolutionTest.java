package uk.matvey.play.leet1370.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        String result = new Solution().sortString("aaaabbbbcccc");

        assertThat(result).isEqualTo("abccbaabccba");
    }

    @Test
    public void case2() {
        String result = new Solution().sortString("rat");

        assertThat(result).isEqualTo("art");
    }

    @Test
    public void case3() {
        String result = new Solution().sortString("leetcode");

        assertThat(result).isEqualTo("cdelotee");
    }

    @Test
    public void case4() {
        String result = new Solution().sortString("ggggggg");

        assertThat(result).isEqualTo("ggggggg");
    }

    @Test
    public void case5() {
        String result = new Solution().sortString("spo");

        assertThat(result).isEqualTo("ops");
    }
}
