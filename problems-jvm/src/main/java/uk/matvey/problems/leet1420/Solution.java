package uk.matvey.problems.leet1420;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int numOfArrays(int n, int m, int k) {
        var dp = new int[n + 1][m + 1][k + 1];
        int mod = 1_000_000_007;
        for (int i = 0; i <= m; i++) {
            dp[n][i][0] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int maxSoFar = m; maxSoFar >= 0; maxSoFar--) {
                for (int remain = 0; remain <= k; remain++) {
                    int ans = 0;
                    for (int num = 0; num < maxSoFar; num++) {
                        ans = (ans + dp[i + 1][maxSoFar][remain]) % mod;
                    }
                    if (remain > 0) {
                        for (int num = maxSoFar + 1; num <= m; num++) {
                            ans = (ans + dp[i + 1][num][remain - 1]) % mod;
                        }
                    }
                    dp[i][maxSoFar][remain] = ans;
                }
            }
        }
        return dp[0][0][k];
    }
}

class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().numOfArrays(2, 3, 1);

        assertThat(result).isEqualTo(6);
    }

    @Test
    public void case2() {
        int result = new Solution().numOfArrays(5, 2, 3);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void case3() {
        int result = new Solution().numOfArrays(9, 1, 1);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case4() {
        int result = new Solution().numOfArrays(50, 100, 25);

        assertThat(result).isEqualTo(34549172);
    }
}
