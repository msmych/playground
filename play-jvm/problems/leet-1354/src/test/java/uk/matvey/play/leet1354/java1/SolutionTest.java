package uk.matvey.play.leet1354.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var target = new int[]{9, 3, 5};

        final var result = new Solution().isPossible(target);

        assertThat(result).isTrue();
    }

    @Test
    public void case2() {
        var target = new int[]{1, 1, 1, 2};

        final var result = new Solution().isPossible(target);

        assertThat(result).isFalse();
    }

    @Test
    public void case3() {
        var target = new int[]{8, 5};

        final var result = new Solution().isPossible(target);

        assertThat(result).isTrue();
    }

    @Test
    public void case4() {
        var target = new int[]{1, 1000000000};

        final var result = new Solution().isPossible(target);

        assertThat(result).isTrue();
    }

    @Test
    public void case5() {
        var target = new int[]{2, 900000001};

        final var result = new Solution().isPossible(target);

        assertThat(result).isTrue();
    }

    @Test
    public void case6() {
        var target = new int[]{1, 1, 999999999};

        final var result = new Solution().isPossible(target);

        assertThat(result).isTrue();
    }

    @Test
    public void case7() {
        var target = new int[]{2, 900000002};

        final var result = new Solution().isPossible(target);

        assertThat(result).isFalse();
    }

    @Test
    public void case8() {
        var target = new int[]{5, 50};

        final var result = new Solution().isPossible(target);

        assertThat(result).isFalse();
    }
}
