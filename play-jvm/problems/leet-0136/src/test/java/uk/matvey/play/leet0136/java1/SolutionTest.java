package uk.matvey.play.leet0136.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        assertThat(new Solution().singleNumber(new int[]{2, 2, 1})).isEqualTo(1);
    }

    @Test
    public void case2() {
        assertThat(new Solution().singleNumber(new int[]{4, 1, 2, 1, 2})).isEqualTo(4);
    }
}
