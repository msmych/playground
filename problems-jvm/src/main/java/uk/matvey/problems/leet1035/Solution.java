package uk.matvey.problems.leet1035;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int maxUncrossedLines(int[] A, int[] B) {
        var dp = new int[A.length + 1][B.length + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[A.length][B.length];
    }
}

class SolutionTest {

    @Test
    public void case1() {
        var a = new int[]{1, 4, 2};
        var b = new int[]{1, 2, 4};

        int result = new Solution().maxUncrossedLines(a, b);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void case2() {
        var a = new int[]{2, 5, 1, 2, 5};
        var b = new int[]{10, 5, 2, 1, 5, 2};

        int result = new Solution().maxUncrossedLines(a, b);

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case3() {
        var a = new int[]{1, 3, 7, 1, 7, 5};
        var b = new int[]{1, 9, 2, 5, 1};

        int result = new Solution().maxUncrossedLines(a, b);

        assertThat(result).isEqualTo(2);
    }
}
