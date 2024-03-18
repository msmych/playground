package uk.matvey.problems.leet1328;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public String breakPalindrome(String palindrome) {
        for (int i = 0; i < palindrome.length(); i++) {
            if ((palindrome.length() % 2 == 0 || i != palindrome.length() / 2) && palindrome.charAt(i) > 'a') {
                return palindrome.substring(0, i) + 'a' + palindrome.substring(i + 1);
            }
            if (palindrome.length() > 1 && i == palindrome.length() - 1) {
                return palindrome.substring(0, i) + 'b' + palindrome.substring(i + 1);
            }
        }
        return "";
    }
}

class SolutionTest {

    @Test
    public void case1() {
        String result = new Solution().breakPalindrome("abccba");

        assertThat(result).isEqualTo("aaccba");
    }

    @Test
    public void case2() {
        String result = new Solution().breakPalindrome("a");

        assertThat(result).isEqualTo("");
    }

    @Test
    public void case3() {
        String result = new Solution().breakPalindrome("aa");

        assertThat(result).isEqualTo("ab");
    }

    @Test
    public void case4() {
        String result = new Solution().breakPalindrome("aba");

        assertThat(result).isEqualTo("abb");
    }
}
