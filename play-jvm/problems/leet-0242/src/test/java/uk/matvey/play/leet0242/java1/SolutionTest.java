package uk.matvey.play.leet0242.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        boolean result = new Solution().isAnagram("anagram", "nagaram");

        assertThat(result).isTrue();
    }

    @Test
    public void case2() {
        boolean result = new Solution().isAnagram("rat", "car");

        assertThat(result).isFalse();
    }
}
