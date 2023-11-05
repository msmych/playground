package uk.matvey.play.leet0438.java1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        List<Integer> result = new Solution().findAnagrams("cbaebabacd", "abc");

        assertThat(result).containsExactly(0, 6);
    }

    @Test
    public void case2() {
        List<Integer> result = new Solution().findAnagrams("abab", "ab");

        assertThat(result).containsExactly(0, 1, 2);
    }
}
