package uk.matvey.problems.leet1347;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int minSteps(String s, String t) {
        var smap = occurrences(s);
        var tmap = occurrences(t);
        int difference = 0;
        for (int i = 0; i < 26; i++) {
            difference += Math.abs(smap[i] - tmap[i]);
        }
        return difference % 2 == 0
            ? difference / 2
            : difference / 2 + 1;
    }

    private int[] occurrences(String s) {
        var map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        return map;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().minSteps("bab", "aba");

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case2() {
        int result = new Solution().minSteps("leetcode", "practice");

        assertThat(result).isEqualTo(5);
    }

    @Test
    public void case3() {
        int result = new Solution().minSteps("anagram", "mangaar");

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void case4() {
        int result = new Solution().minSteps("xxyyzz", "xxyyzz");

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void case5() {
        int result = new Solution().minSteps("friend", "family");

        assertThat(result).isEqualTo(4);
    }
}
