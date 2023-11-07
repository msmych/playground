package uk.matvey.play.leet0011.java1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

    @Test
    public void case1() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int result = new Solution().maxArea(height);

        assertThat(result).isEqualTo(49);
    }
}
