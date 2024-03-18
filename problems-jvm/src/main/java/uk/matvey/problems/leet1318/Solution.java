package uk.matvey.problems.leet1318;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int minFlips(int a, int b, int c) {
        var sa = Integer.toString(a, 2);
        var sb = Integer.toString(b, 2);
        var sc = Integer.toString(c, 2);
        var stats = Stream.of(sa, sb, sc)
            .mapToInt(String::length)
            .summaryStatistics();
        int maxLen = stats.getMax();
        int minLen = stats.getMin();
        for (int i = minLen; i < maxLen; i++) {
            if (sa.length() == i) {
                sa = "0" + sa;
            }
            if (sb.length() == i) {
                sb = "0" + sb;
            }
            if (sc.length() == i) {
                sc = "0" + sc;
            }
        }
        int flips = 0;
        for (int i = 0; i < maxLen; i++) {
            if (sc.charAt(i) == '1') {
                if (sa.charAt(i) == '0' && sb.charAt(i) == '0') {
                    flips++;
                }
            } else {
                if (sa.charAt(i) == '1') {
                    flips++;
                }
                if (sb.charAt(i) == '1') {
                    flips++;
                }
            }
        }
        return flips;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().minFlips(2, 6, 5);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case2() {
        int result = new Solution().minFlips(4, 2, 7);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case3() {
        int result = new Solution().minFlips(1, 2, 3);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void case4() {
        int result = new Solution().minFlips(8, 3, 5);

        assertThat(result).isEqualTo(3);
    }
}
