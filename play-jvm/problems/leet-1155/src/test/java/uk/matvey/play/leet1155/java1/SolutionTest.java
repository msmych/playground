package uk.matvey.play.leet1155.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        assertThat(new Solution().numRollsToTarget(1, 6, 3)).isEqualTo(1);
    }

    @Test
    public void case2() {
        assertThat(new Solution().numRollsToTarget(2, 6, 7)).isEqualTo(6);
    }

    @Test
    public void case3() {
        assertThat(new Solution().numRollsToTarget(30, 30, 500)).isEqualTo(222616187);
    }
}
