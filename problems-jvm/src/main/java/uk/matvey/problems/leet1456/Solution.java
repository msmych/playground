package uk.matvey.problems.leet1456;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int maxVowels(String s, int k) {
        var vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int max = (int) s.substring(0, k).chars()
            .mapToObj(c -> (char) c)
            .filter(vowels::contains)
            .count();
        for (int i = 0, count = max; i + k < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                count--;
            }
            if (vowels.contains(s.charAt(i + k))) {
                count++;
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }
}

class SolutionTest {

    @Test
    void case1() {
        assertThat(new Solution().maxVowels("abciiidef", 3)).isEqualTo(3);
    }

    @Test
    void case2() {
        assertThat(new Solution().maxVowels("aeiou", 2)).isEqualTo(2);
    }

    @Test
    void case3() {
        assertThat(new Solution().maxVowels("leetcode", 3)).isEqualTo(2);
    }

    @Test
    void case4() {
        assertThat(new Solution().maxVowels("rhythms", 4)).isEqualTo(0);
    }

    @Test
    void case5() {
        assertThat(new Solution().maxVowels("tryhard", 4)).isEqualTo(1);
    }
}
