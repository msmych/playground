package uk.matvey.problems.leet0342;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Solution {

    public boolean isPowerOfFour(int n) {
        return Integer.toString(n, 4).matches("^10*$");
    }
}

class SolutionTest {

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
