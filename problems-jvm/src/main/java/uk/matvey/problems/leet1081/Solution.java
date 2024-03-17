package uk.matvey.problems.leet1081;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public String smallestSubsequence(String text) {
        if (text.isEmpty()) {
            return "";
        }
        var count = new int[26];
        text.chars().map(c -> c - 'a').forEach(c -> count[c]++);
        var min = 0;
        for (var i = 0; i < text.length(); i++) {
            if (text.charAt(i) < text.charAt(min)) {
                min = i;
            }
            if (--count[text.charAt(i) - 'a'] == 0) {
                break;
            }
        }
        return text.charAt(min) + smallestSubsequence(text.substring(min + 1).replaceAll("" + text.charAt(min), ""));
    }
}

class SolutionTest {

    @Test
    public void case1() {
        String result = new Solution().smallestSubsequence("cdadabcc");

        assertThat(result).isEqualTo("adbc");
    }

    @Test
    public void case2() {
        String result = new Solution().smallestSubsequence("abcd");

        assertThat(result).isEqualTo("abcd");
    }

    @Test
    public void case3() {
        String result = new Solution().smallestSubsequence("ecbacba");

        assertThat(result).isEqualTo("eacb");
    }

    @Test
    public void case4() {
        String result = new Solution().smallestSubsequence("leetcode");

        assertThat(result).isEqualTo("letcod");
    }
}
