package uk.matvey.play.leet2147.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().numberOfWays("SSPPSPS");

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case2() {
        int result = new Solution().numberOfWays("PPSPSP");

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case3() {
        int result = new Solution().numberOfWays("S");

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void case4() {
        int result = new Solution().numberOfWays("P");

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void case5() {
        int result = new Solution().numberOfWays("SPPSSSSPPS");

        assertThat(result).isEqualTo(1);
    }
}
