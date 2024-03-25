package uk.matvey.problems.leet1404;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int numSteps(String s) {
        var steps = 0;
        for (var sb = new StringBuilder(s); sb.length() > 1; steps++) {
            if (sb.charAt(sb.length() - 1) == '0') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                int i = sb.length() - 1;
                for (; i >= 0 && sb.charAt(i) == '1'; i--) {
                    sb.setCharAt(i, '0');
                }
                if (i < 0) {
                    sb.insert(0, "1");
                } else {
                    sb.setCharAt(i, '1');
                }
            }
        }
        return steps;
    }
}

class SolutionTest {

    @Test
    void case1() {
        assertThat(new Solution().numSteps("1101")).isEqualTo(6);
    }

    @Test
    void case2() {
        assertThat(new Solution().numSteps("10")).isEqualTo(1);
    }

    @Test
    void case3() {
        assertThat(new Solution().numSteps("1")).isEqualTo(0);
    }

    @Test
    void case4() {
        assertThat(new Solution().numSteps("1111011110000011100000110001011011110010111001010111110001")).isEqualTo(85);
    }
}
