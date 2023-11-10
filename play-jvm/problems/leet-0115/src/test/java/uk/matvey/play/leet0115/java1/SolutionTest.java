package uk.matvey.play.leet0115.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().numDistinct("rabbbit", "rabbit");

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case2() {
        int result = new Solution().numDistinct("babgbag", "bag");

        assertThat(result).isEqualTo(5);
    }
}
