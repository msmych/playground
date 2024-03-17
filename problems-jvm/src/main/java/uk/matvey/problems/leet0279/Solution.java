package uk.matvey.problems.leet0279;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int numSquares(int n) {
        var dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; i + j * j <= n; j++) {
                if (dp[i] + 1 < dp[i + j * j]) {
                    dp[i + j * j] = dp[i] + 1;
                }
            }
        }
        return dp[n];
    }
}

class SolutionTest {

    @Test
    public void case1() {
        assertThat(new Solution().numSquares(12)).isEqualTo(3);
    }

    @Test
    public void case2() {
        assertThat(new Solution().numSquares(13)).isEqualTo(2);
    }
}
