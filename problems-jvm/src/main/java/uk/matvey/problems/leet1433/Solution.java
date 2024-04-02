package uk.matvey.problems.leet1433;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {

    public boolean checkIfCanBreak(String s1, String s2) {
        var arr1 = s1.chars().sorted().toArray();
        var arr2 = s2.chars().sorted().toArray();
        return IntStream.range(0, s1.length()).allMatch(i -> arr1[i] >= arr2[i]) ||
            IntStream.range(0, s2.length()).allMatch(i -> arr2[i] >= arr1[i]);
    }
}

class SolutionTest {

    @Test
    void case1() {
        assertThat(new Solution().checkIfCanBreak("abc", "xya")).isTrue();
    }

    @Test
    void case2() {
        assertThat(new Solution().checkIfCanBreak("abe", "acd")).isFalse();
    }

    @Test
    void case3() {
        assertThat(new Solution().checkIfCanBreak("leetcodee", "interview")).isTrue();
    }
}
