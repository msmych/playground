package uk.matvey.problems.leet0003;

import java.util.HashMap;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        var charIndexes = new HashMap<Character, Integer>();
        var maxLength = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            var index = charIndexes.get(c);
            if (index != null && index > i) {
                i = index;
            }
            var length = j - i + 1;
            if (length > maxLength) {
                maxLength = length;
            }
            charIndexes.put(c, j + 1);
        }
        return maxLength;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().lengthOfLongestSubstring("abcabcbb");

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case2() {
        int result = new Solution().lengthOfLongestSubstring("bbbbb");

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case3() {
        int result = new Solution().lengthOfLongestSubstring("pwwkew");

        assertThat(result).isEqualTo(3);
    }
}
