package uk.matvey.play.leet1320.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        int result = new Solution().minimumDistance("CAKE");

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case2() {
        int result = new Solution().minimumDistance("HAPPY");

        assertThat(result).isEqualTo(6);
    }

    @Test
    public void case3() {
        int result = new Solution().minimumDistance("NEW");

        assertThat(result).isEqualTo(3);
    }

    @Test
    public void case4() {
        int result = new Solution().minimumDistance("YEAR");

        assertThat(result).isEqualTo(7);
    }
}
