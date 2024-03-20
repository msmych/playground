package uk.matvey.problems.leet2896;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int minOperations(String s1, String s2, int x) {
        var diffs = new ArrayList<Integer>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffs.add(i);
            }
        }
        if (diffs.size() % 2 == 1) {
            return -1;
        }
        var dp = new int[diffs.size() + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = x + dp[i - 1];
            if (i >= 2) {
                dp[i] = Math.min(dp[i], 2 * (diffs.get(i - 1) - diffs.get(i - 2)) + dp[i - 2]);
            }
        }
        return dp[diffs.size()] / 2;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var s1 = "1100011000";
        var s2 = "0101001010";

        int result = new Solution().minOperations(s1, s2, 2);

        assertThat(result).isEqualTo(4);
    }

    @Test
    public void case2() {
        var s1 = "10110";
        var s2 = "00011";

        int result = new Solution().minOperations(s1, s2, 4);

        assertThat(result).isEqualTo(-1);
    }
}
