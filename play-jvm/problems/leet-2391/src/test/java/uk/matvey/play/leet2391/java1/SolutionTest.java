package uk.matvey.play.leet2391.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        var garbage = new String[]{"G", "P", "GP", "GG"};
        var travel = new int[]{2, 4, 3};

        int result = new Solution().garbageCollection(garbage, travel);

        assertThat(result).isEqualTo(21);
    }

    @Test
    public void case2() {
        var garbage = new String[]{"MMM", "PGM", "GP"};
        var travel = new int[]{3, 10};

        int result = new Solution().garbageCollection(garbage, travel);

        assertThat(result).isEqualTo(37);
    }
}
