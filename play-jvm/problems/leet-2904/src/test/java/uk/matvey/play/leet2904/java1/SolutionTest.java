package uk.matvey.play.leet2904.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        String result = new Solution().shortestBeautifulSubstring("100011001", 3);

        assertThat(result).isEqualTo("11001");
    }

    @Test
    public void case2() {
        String result = new Solution().shortestBeautifulSubstring("1011", 2);

        assertThat(result).isEqualTo("11");
    }

    @Test
    public void case3() {
        String result = new Solution().shortestBeautifulSubstring("000", 1);

        assertThat(result).isEqualTo("");
    }

    @Test
    public void case4() {
        String result = new Solution().shortestBeautifulSubstring("001110101101101111", 10);

        assertThat(result).isEqualTo("10101101101111");
    }

    @Test
    public void case5() {
        String result = new Solution().shortestBeautifulSubstring("1100100101011001001", 7);

        assertThat(result).isEqualTo("1100100101011");
    }
}
