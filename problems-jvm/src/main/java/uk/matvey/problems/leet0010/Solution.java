package uk.matvey.problems.leet0010;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Solution {

    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        var firstMatch = false;
        if (!s.isEmpty()) {
            var cs = s.charAt(0);
            var cp = p.charAt(0);
            firstMatch = cs == cp || cp == '.';
        }
        if (p.length() > 1 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || firstMatch && isMatch(s.substring(1), p);
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}

class SolutionTest {

    @Test
    public void case1() {
        boolean result = new Solution().isMatch("aa", "a");

        assertThat(result).isFalse();
    }

    @Test
    public void case2() {
        boolean result = new Solution().isMatch("aa", "a*");

        assertThat(result).isTrue();
    }

    @Test
    public void case3() {
        boolean result = new Solution().isMatch("ab", ".*");

        assertThat(result).isTrue();
    }

    @Test
    public void case4() {
        boolean result = new Solution().isMatch("aab", "c*a*b");

        assertThat(result).isTrue();
    }

    @Test
    public void case5() {
        boolean result = new Solution().isMatch("mississippi", "mis*is*p*.");

        assertThat(result).isFalse();
    }
}
