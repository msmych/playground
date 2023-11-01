package uk.matvey.play.leet2433.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var pref = new int[]{5, 2, 0, 3, 1};

        int[] result = new Solution().findArray(pref);

        assertThat(result).containsExactly(5, 7, 2, 3, 2);
    }

    @Test
    public void case2() {
        var pref = new int[]{13};

        int[] result = new Solution().findArray(pref);

        assertThat(result).containsExactly(13);
    }
}
