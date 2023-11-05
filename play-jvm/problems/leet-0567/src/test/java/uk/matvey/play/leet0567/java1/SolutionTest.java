package uk.matvey.play.leet0567.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        boolean result = new Solution().checkInclusion("ab", "eidbaooo");

        assertThat(result).isTrue();
    }

    @Test
    public void case2() {
        boolean result = new Solution().checkInclusion("ab", "eidboaoo");

        assertThat(result).isFalse();
    }
}
