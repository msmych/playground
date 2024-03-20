package uk.matvey.problems.leet2147;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    private static final int MOD = 1_000_000_007;

    public int numberOfWays(String corridor) {
        if (corridor.indexOf('S') == -1) {
            return 0;
        }
        if (corridor.chars().filter(c -> c == 'S').count() % 2 == 1) {
            return 0;
        }
        long count = 1;
        int seats = 0;
        int plants = 0;
        for (int i = 0; i < corridor.length(); i++) {
            char c = corridor.charAt(i);
            if (c == 'S') {
                seats++;
                if (seats % 2 == 1) {
                    if (seats > 1) {
                        count *= plants + 1;
                        count %= MOD;
                    }
                }
                plants = 0;
            } else {
                plants++;
            }
        }
        return (int) count % MOD;
    }
}

class SolutionTest {

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
