package uk.matvey.problems.leet1143;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        var dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                dp[i + 1][j + 1] = text1.charAt(i) == text2.charAt(j)
                    ? dp[i][j] + 1
                    : Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        }
        return Arrays.stream(dp)
            .mapToInt(row -> Arrays.stream(row).max().orElse(0))
            .max().orElse(0);
    }
}

class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().longestCommonSubsequence("abcde", "ace");

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case2() {
        int result = new Solution().longestCommonSubsequence("abc", "abc");

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case3() {
        int result = new Solution().longestCommonSubsequence("abc", "def");

        assertThat(result).isEqualTo(0);
    }
}
