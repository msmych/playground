package uk.matvey.play.leet0907.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var arr = new int[]{3, 1, 2, 4};

        final var result = new Solution().sumSubarrayMins(arr);

        assertThat(result).isEqualTo(17);
    }

    @Test
    public void case2() {
        var arr = new int[]{11, 81, 94, 43, 3};

        final var result = new Solution().sumSubarrayMins(arr);

        assertThat(result).isEqualTo(444);
    }
}
