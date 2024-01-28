package uk.matvey.play.leet0629.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        final var result = new Solution().kInversePairs(3, 0);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void case2() {
        final var result = new Solution().kInversePairs(3, 1);

        assertThat(result).isEqualTo(2);
    }
}
