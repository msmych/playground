package uk.matvey.problems.leet1422;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int maxScore(String s) {
        var ones = new int[s.length() + 1];
        for (var i = 0; i < s.length(); i++) {
            ones[i + 1] = s.charAt(i) == '1' ? ones[i] + 1 : ones[i];
        }
        var zeroes = 0;
        var max = 0;
        for (var i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zeroes++;
            }
            var score = zeroes + ones[ones.length - 1] - ones[i + 1];
            if (score > max) {
                max = score;
            }
        }
        return max;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        assertThat(new Solution().maxScore("00111")).isEqualTo(5);
    }

    @Test
    public void case2() {
        assertThat(new Solution().maxScore("1111")).isEqualTo(3);
    }
}
