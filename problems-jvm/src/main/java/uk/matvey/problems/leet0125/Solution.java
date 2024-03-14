package uk.matvey.problems.leet0125;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        var reversed = new StringBuilder(s).reverse().toString();
        return s.equalsIgnoreCase(reversed);
    }
}

class SolutionTest {

    @Test
    public void case1() {
        boolean result = new Solution().isPalindrome("A man, a plan, a canal: Panama");

        assertThat(result).isTrue();
    }

    @Test
    public void case2() {
        boolean result = new Solution().isPalindrome("race a car");

        assertThat(result).isFalse();
    }
}
