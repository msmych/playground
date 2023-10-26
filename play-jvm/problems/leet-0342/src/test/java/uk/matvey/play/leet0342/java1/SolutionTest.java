package uk.matvey.play.leet0342.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        boolean result = new Solution().isPowerOfFour(16);

        assertThat(result).isTrue();
    }

    @Test
    public void case2() {
        boolean result = new Solution().isPowerOfFour(5);

        assertThat(result).isFalse();
    }

    @Test
    public void case3() {
        boolean result = new Solution().isPowerOfFour(1);

        assertThat(result).isTrue();
    }
}
