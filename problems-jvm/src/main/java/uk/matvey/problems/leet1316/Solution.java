package uk.matvey.problems.leet1316;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int distinctEchoSubstrings(String text) {
        var echoes = new HashSet<String>();
        for (int i = 1; i <= text.length() / 2; i++) {
            for (int j = 0; j + 2 * i <= text.length(); j++) {
                var echo = text.substring(j, j + i);
                if (!echoes.contains(echo) && echo.equals(text.substring(j + i, j + 2 * i))) {
                    echoes.add(echo);
                }
            }
        }
        return echoes.size();
    }
}

class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().distinctEchoSubstrings("abcabcabc");

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case2() {
        int result = new Solution().distinctEchoSubstrings("leetcodeleetcode");

        assertThat(result).isEqualTo(2);
    }
}
