package uk.matvey.problems.leet1358;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public int numberOfSubstrings(String s) {
        int count = 0;
        int[] letters = new int[]{-1, -1, -1};
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a'] = i;
            count += 1 + Arrays.stream(letters).min().getAsInt();
        }
        return count;
    }
}

class SolutionTest {

    @Test
    public void case1() {
        final var result = new Solution().numberOfSubstrings("abcabc");

        assertThat(result).isEqualTo(10);
    }

    @Test
    public void case2() {
        final var result = new Solution().numberOfSubstrings("aaacb");

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case3() {
        final var result = new Solution().numberOfSubstrings("abc");

        assertThat(result).isEqualTo(1);
    }
}
